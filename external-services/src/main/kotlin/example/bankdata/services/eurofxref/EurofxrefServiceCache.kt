package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.utils.cache.*
import example.bankdata.utils.system.*
import jakarta.annotation.*
import jakarta.decorator.*
import jakarta.inject.*
import kotlin.time.Duration.Companion.days

@Decorator
@Priority(1)
class EurofxrefServiceCache(
    private val delegate: EurofxrefService,
    private val getSystemTime: () -> SystemNanoTime
) : EurofxrefService {

    @Inject
    constructor(@Delegate delegate: EurofxrefService) : this(delegate, getSystemTime = SystemNanoTime::now)

    private val cache: TimedAsyncCache<EurofxrefDailyCurrenciesDomain> =
        TimedAsyncCache(cacheDuration = 1.days, getSystemTime = getSystemTime)

    override suspend fun dailyCurrencies(): Result<EurofxrefDailyCurrenciesDomain> = runCatching {
        val value: EurofxrefDailyCurrenciesDomain = cache.valueIfValidOrUpdateWith {
            delegate.dailyCurrencies().getOrThrow()
        }
        return Result.success(value)
    }
}
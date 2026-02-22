package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.utils.cache.*
import example.bankdata.utils.system.*
import jakarta.annotation.*
import jakarta.decorator.*
import jakarta.inject.*
import kotlin.time.Duration.Companion.days

class EurofxrefServiceCache(
    private val delegate: EurofxrefService,
    private val getSystemTime: () -> SystemNanoTime
) : EurofxrefService {

    constructor(delegate: EurofxrefService) : this(delegate, getSystemTime = SystemNanoTime::now)

    private val cache: TimedAsyncCache<EurofxrefDailyCurrenciesDomain> =
        TimedAsyncCache(cacheDuration = 1.days, getSystemTime = getSystemTime)

    override suspend fun dailyCurrencies(): Result<EurofxrefDailyCurrenciesDomain> = runCatching {
        val value: EurofxrefDailyCurrenciesDomain = cache.valueIfValidOrUpdateWith {
            val result: Result<EurofxrefDailyCurrenciesDomain> = delegate.dailyCurrencies()
            return@valueIfValidOrUpdateWith result.getOrThrow()
        }
        return Result.success(value)
    }
}
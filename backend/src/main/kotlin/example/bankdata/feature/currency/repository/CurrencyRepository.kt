package example.bankdata.feature.currency.repository

import example.bankdata.models.general.*
import example.bankdata.services.eurofxref.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.services.eurofxref.models.domain.currencies.operations.*
import example.bankdata.utils.kotlin.result.*
import jakarta.enterprise.context.*
import example.bankdata.models.general.BigDecimalAsString
import java.math.*

@ApplicationScoped
class CurrencyRepository(
    private val service: EurofxrefService
) {
    suspend fun convertDkkToUsd(
        dkk: BigDecimalAsString
    ): Result<BigDecimal> {
        val currenciesNow: Result<EurofxrefDailyCurrenciesDomain> = with(service) {
            dailyCurrencies()
        }

        val result: EurofxrefDailyCurrenciesDomain = currenciesNow.valueOrOnFailure { it: Throwable ->
            return Result.failure(it)
        }

        val converter: CurrencyConverterDomain = result.dkkToUsdOrNull()
            ?: return Result.failure(RuntimeException("Cannot convert dkk to usd, missing or invalid information from exchange"))

        return Result.success(converter.convert(dkk.toBigDecimal()))
    }
}
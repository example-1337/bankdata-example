package example.bankdata.services.eurofxref.models.domain.currencies.operations

import example.bankdata.models.general.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.models.general.BigDecimalAsString

fun EurofxrefDailyCurrenciesDomain.dkkToUsdOrNull(): CurrencyConverterDomain? {
    val dkk: BigDecimalAsString = dkk ?: return null
    val usd: BigDecimalAsString = usd ?: return null

    return CurrencyConverterDomain(
        fromRate = dkk.toBigDecimal(),
        toRate = usd.toBigDecimal(),
    )
}


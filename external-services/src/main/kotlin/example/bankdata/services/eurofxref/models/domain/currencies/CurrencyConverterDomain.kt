package example.bankdata.services.eurofxref.models.domain.currencies

import java.math.*

class CurrencyConverterDomain(
    val fromRate: BigDecimal,
    val toRate: BigDecimal,
) {

    fun convert(valueInFrom: BigDecimal, scale: Int = 10): BigDecimal {
        val inBaseCurrency: BigDecimal = valueInFrom.divide(
            fromRate,
            scale,
            RoundingMode.HALF_UP
        )
        val converted: BigDecimal = inBaseCurrency * toRate
        return converted
    }
}
package example.bankdata.models.currency.dto

import example.bankdata.models.general.*
import kotlinx.serialization.*

@Serializable
data class CurrencyDto(
    val amount: BigDecimalAsString,
    val currencyType: String
) {
    companion object
}
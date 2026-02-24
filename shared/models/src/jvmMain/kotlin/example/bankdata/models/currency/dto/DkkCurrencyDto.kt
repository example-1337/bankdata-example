package example.bankdata.models.currency.dto

import example.bankdata.models.general.*
import kotlinx.serialization.*

@Serializable
data class DkkCurrencyDto(
    val amount: BigDecimalAsString
) {
    companion object
}
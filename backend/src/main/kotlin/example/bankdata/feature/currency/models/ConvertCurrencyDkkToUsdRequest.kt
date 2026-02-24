package example.bankdata.feature.currency.models

import example.bankdata.models.general.*
import kotlinx.serialization.*
import example.bankdata.models.general.BigDecimalAsString

@Serializable
data class ConvertCurrencyDkkToUsdRequest(
    val dkk: BigDecimalAsString
) {
    companion object
}
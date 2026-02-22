package example.bankdata.feature.currency.models

import kotlinx.serialization.*

@Serializable
data class ConvertCurrencyDkkToUsdResponse(
    val dkk: String,
    val usd: String
) {
    companion object
}
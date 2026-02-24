package example.bankdata.feature.account.models

import example.bankdata.models.currency.dto.*
import kotlinx.serialization.*
import example.bankdata.models.currency.dto.DkkCurrencyDto

@Serializable
data class CreateNewAccountRequestDto(
    val firstName: String,
    val lastName: String,
    val startingBalance: DkkCurrencyDto
) {
    companion object
}

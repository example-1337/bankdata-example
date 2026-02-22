package example.bankdata.feature.money.models

import example.bankdata.models.currency.dto.*
import kotlinx.serialization.*

@Serializable
data class MoneyBalanceResponseDto(
    val balance: CurrencyDto
) {
    companion object
}
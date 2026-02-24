package example.bankdata.feature.money.models

import example.bankdata.models.account.*
import example.bankdata.models.currency.dto.*
import kotlinx.serialization.*
import example.bankdata.models.account.AccountNumber
import example.bankdata.models.currency.dto.DkkCurrencyDto

@Serializable
data class MoneyTransferRequestDto(
    val from: AccountNumber,
    val to: AccountNumber,
    val money: DkkCurrencyDto
)
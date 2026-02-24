package example.bankdata.feature.money.bll

import example.bankdata.feature.money.models.*
import example.bankdata.models.currency.bll.*
import example.bankdata.models.currency.domain.*
import example.bankdata.models.currency.bll.toCurrencyDto

fun DkkCurrencyDomain.toBalanceResponseDto(): MoneyBalanceResponseDto {
    return MoneyBalanceResponseDto(
        balance = toCurrencyDto()
    )
}
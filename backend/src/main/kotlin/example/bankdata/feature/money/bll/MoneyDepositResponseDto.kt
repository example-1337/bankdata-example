package example.bankdata.feature.money.bll

import example.bankdata.feature.money.models.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.bll.*


fun AccountDomain.toMoneyDepositResponseDto(): MoneyDepositResponseDto {
    return MoneyDepositResponseDto(balance.toCurrencyDto())
}
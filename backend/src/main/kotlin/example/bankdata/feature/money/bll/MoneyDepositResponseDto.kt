package example.bankdata.feature.money.bll

import example.bankdata.feature.money.models.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.bll.*
import example.bankdata.models.account.domain.AccountDomain
import example.bankdata.models.currency.bll.toCurrencyDto


fun AccountDomain.toMoneyDepositResponseDto(): MoneyDepositResponseDto {
    return MoneyDepositResponseDto(balance.toCurrencyDto())
}
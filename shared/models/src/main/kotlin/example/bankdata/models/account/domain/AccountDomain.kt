package example.bankdata.models.account.domain

import example.bankdata.models.account.*
import example.bankdata.models.currency.domain.*

data class AccountDomain(
    val accountNumber: AccountNumber,
    val balance: DkkCurrencyDomain,
    val user: AccountUserDomain
) {
    companion object
}
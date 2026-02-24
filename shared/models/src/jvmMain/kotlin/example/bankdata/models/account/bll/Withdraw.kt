package example.bankdata.models.account.bll

import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.domain.*

fun AccountDomain.withdraw(value: DkkCurrencyDomain): AccountDomain {
    return copy(
        balance = balance - value
    )
}

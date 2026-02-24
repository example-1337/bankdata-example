package example.bankdata.models.account.bll

import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.domain.*

fun AccountDomain.isBalanceLessThan(amount: DkkCurrencyDomain): Boolean {
    return balance.compareTo(amount)
}
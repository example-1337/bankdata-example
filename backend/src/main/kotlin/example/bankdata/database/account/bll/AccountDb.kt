package example.bankdata.database.account.bll

import example.bankdata.database.account.models.AccountDb
import example.bankdata.database.account.models.BalanceDb
import example.bankdata.database.account.models.UserInfoDb
import example.bankdata.models.account.AccountNumber
import example.bankdata.models.account.domain.AccountDomain
import example.bankdata.models.account.domain.AccountUserDomain
import example.bankdata.models.currency.domain.DkkCurrencyDomain

fun AccountDb.updateFrom(updated: AccountDomain) {
    accountNumber = updated.accountNumber.raw
    balance.balance = updated.balance.amount
    userInfo.firstName = updated.user.firstName
    userInfo.lastName = updated.user.lastName
}

fun AccountDomain.toDb(): AccountDb = AccountDb(
    id = 0,
    accountNumber = accountNumber.raw,
    balance = BalanceDb(
        id = 0,
        balance = balance.amount
    ),
    userInfo = UserInfoDb(
        id = 0,
        firstName = user.firstName,
        lastName = user.lastName,
    )
)

fun AccountDb.toDomain(): AccountDomain {
    return AccountDomain(
        accountNumber = AccountNumber(accountNumber),
        balance = DkkCurrencyDomain(balance.balance),
        user = AccountUserDomain(
            firstName = userInfo.firstName,
            lastName = userInfo.lastName,
        )
    )
}

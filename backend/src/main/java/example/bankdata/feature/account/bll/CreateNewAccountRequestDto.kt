package example.bankdata.feature.account.bll

import example.bankdata.feature.account.models.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.bll.*

fun CreateNewAccountRequestDto.toDomain(
    newAccountNumber: AccountNumber,
): AccountDomain {
    return AccountDomain(
        accountNumber = newAccountNumber,
        balance = startingBalance.toDomain(),
        user = AccountUserDomain(
            firstName = firstName,
            lastName = lastName
        )
    )
}
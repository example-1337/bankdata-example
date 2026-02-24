package example.bankdata.feature.account.repository

import example.bankdata.feature.account.bll.*
import example.bankdata.feature.account.models.*
import example.bankdata.feature.account.service.*
import example.bankdata.models.account.*
import example.bankdata.models.account.bll.*
import example.bankdata.models.account.domain.*
import jakarta.enterprise.context.*
import example.bankdata.models.account.AccountNumber
import example.bankdata.models.account.bll.newFromUuid
import example.bankdata.models.account.domain.AccountDomain

@ApplicationScoped
class AccountRepository(
    val service: AccountService
) {
    fun createAccount(newAccount: CreateNewAccountRequestDto): AccountDomain {
        val newAccount: AccountDomain = newAccount.toDomain(
            newAccountNumber = AccountNumber.newFromUuid()
        )

        service.addAccount(newAccount)
        return newAccount
    }
}


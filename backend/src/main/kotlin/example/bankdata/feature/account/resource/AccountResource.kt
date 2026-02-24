package example.bankdata.feature.account.resource

import example.bankdata.feature.account.models.*
import example.bankdata.feature.account.repository.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import jakarta.ws.rs.*
import example.bankdata.models.account.AccountNumber
import example.bankdata.models.account.domain.AccountDomain

@Path("/account")
class AccountResource(
    private val accountRepository: AccountRepository
) {

    @Path("/create")
    @POST
    fun createAccount(
        newAccount: CreateNewAccountRequestDto
    ): AccountNumber {
        val result: AccountDomain = accountRepository.createAccount(newAccount)
        return result.accountNumber
    }
}
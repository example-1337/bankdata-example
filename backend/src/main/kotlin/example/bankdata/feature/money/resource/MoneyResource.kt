package example.bankdata.feature.money.resource

import example.bankdata.feature.money.bll.*
import example.bankdata.feature.money.models.*
import example.bankdata.feature.money.repository.*
import example.bankdata.feature.money.repository.models.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.bll.*
import example.bankdata.models.currency.domain.*
import jakarta.ws.rs.*

@Path("/money")
class MoneyResource(
    private val repo: MoneyRepository
) {

    @Path("/balance/{accountNumber}")
    @GET
    fun getBalance(accountNumber: AccountNumber): MoneyBalanceResponseDto {
        val balance: DkkCurrencyDomain = repo.getBalance(accountNumber).getOrThrow()

        return balance.toBalanceResponseDto()
    }

    @Path("/deposit")
    @POST
    fun deposit(request: MoneyDepositRequestDto): MoneyDepositResponseDto {
        val updated: AccountDomain = repo.deposit(
            toAccount = request.to,
            withMoney = request.money.toDomain()
        ).getOrThrow()

        return updated.toMoneyDepositResponseDto()
    }

    @Path("/transfer")
    @POST
    fun transfer(requestDto: MoneyTransferRequestDto): MoneyRepositoryTransferResult {
        val transferResult: MoneyRepositoryTransferResult =
            repo.transfer(
                from = requestDto.from,
                to = requestDto.to,
                transferAmount = requestDto.money.toDomain()
            )
        return transferResult
    }
}
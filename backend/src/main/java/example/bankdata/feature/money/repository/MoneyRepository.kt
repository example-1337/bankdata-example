package example.bankdata.feature.money.repository

import example.bankdata.database.*
import example.bankdata.feature.money.repository.models.*
import example.bankdata.models.account.*
import example.bankdata.models.account.bll.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.domain.*
import jakarta.enterprise.context.*
import jakarta.transaction.Transactional
import kotlin.random.*

@ApplicationScoped
class MoneyRepository(
    private val dbService: InMemoryDbService
) {

    private val random: Random by lazy { Random(42) }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    fun deposit(toAccount: AccountNumber, withMoney: DkkCurrencyDomain): Result<AccountDomain> {
        val account: AccountDomain? = dbService.get(toAccount)
        if (account == null) {
            return Result.failure(IllegalArgumentException("Account not found: $toAccount"))
        }

        val updatedAccount: AccountDomain = account.deposit(withMoney)

        dbService.updateAccount(updatedAccount)

        return Result.success(updatedAccount)
    }

    fun getBalance(accountNumber: AccountNumber): Result<DkkCurrencyDomain> {
        val account: AccountDomain? = dbService.get(accountNumber)
        if (account == null) {
            return Result.failure(IllegalArgumentException("Account not found: $accountNumber"))
        }

        return Result.success(account.balance)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    fun transfer(
        from: AccountNumber,
        to: AccountNumber,
        transferAmount: DkkCurrencyDomain
    ): MoneyRepositoryTransferResult {
        val fromAccount: AccountDomain = dbService.get(from) ?: return MoneyRepositoryTransferResult.SenderNotFound
        val toAccount: AccountDomain = dbService.get(to) ?: return MoneyRepositoryTransferResult.RecipientNotFound

        if (fromAccount == toAccount) {
            return MoneyRepositoryTransferResult.SameAccountError
        }

        if (fromAccount.isBalanceLessThan(transferAmount)) {
            return MoneyRepositoryTransferResult.InsufficientBalance
        }

        if (isTransferPossibleFraud(fromAccount, transferAmount)) {
            return MoneyRepositoryTransferResult.PossibleFraud
        }

        val updatedFrom: AccountDomain = fromAccount.withdraw(transferAmount)
        val updatedTo: AccountDomain = toAccount.deposit(transferAmount)

        dbService.updateAccount(updatedFrom)
        dbService.updateAccount(updatedTo)

        return MoneyRepositoryTransferResult.Success
    }

    private fun isTransferPossibleFraud(
        fromAccount: AccountDomain,
        transferAmount: DkkCurrencyDomain
    ): Boolean {
        return random.nextBoolean()
    }
}
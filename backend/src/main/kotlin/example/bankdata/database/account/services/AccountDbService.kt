package example.bankdata.database.account.services

import example.bankdata.database.account.bll.*
import example.bankdata.database.account.models.*
import example.bankdata.database.account.repository.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import jakarta.enterprise.context.*
import jakarta.transaction.*
import example.bankdata.models.account.AccountNumber
import example.bankdata.models.account.domain.AccountDomain

@ApplicationScoped
class AccountDbService(
    private val repository: AccountDbRepository
) {

    fun getDomain(accountNumber: AccountNumber): AccountDomain? {
        return repository.findByAccountNumber(accountNumber)?.toDomain()
    }

    @Transactional
    fun addAccount(domain: AccountDomain) {
        repository.persist(domain.toDb())
    }

    @Transactional
    fun updateAccount(updated: AccountDomain) {
        val original: AccountDb = repository.requireByAccountNumber(accountNumber = updated.accountNumber)
        original.updateFrom(updated)
        repository.persist(original)
    }
}
package example.bankdata.database

import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import jakarta.enterprise.context.*

@ApplicationScoped
class InMemoryDbService {
    private val inMemory = hashMapOf<AccountNumber, AccountDomain>()

    fun get(accountNumber: AccountNumber): AccountDomain? {
        return inMemory[accountNumber]
    }

    fun addAccount(domain: AccountDomain) {
        if (containsAccount(domain.accountNumber)) {
            throw IllegalArgumentException("Account with this accountNumber already exists")
        }
        inMemory[domain.accountNumber] = domain
    }

    fun updateAccount(domain: AccountDomain) {
        if (!containsAccount(domain.accountNumber)) {
            throw IllegalArgumentException("Account with this accountNumber does not exists")
        }
        inMemory[domain.accountNumber] = domain
    }

    fun containsAccount(accountNumber: AccountNumber): Boolean {
        return inMemory.containsKey(accountNumber)
    }

}
package example.bankdata.database.account.repository

import example.bankdata.database.account.models.*
import example.bankdata.models.account.*
import io.quarkus.hibernate.orm.panache.kotlin.*
import jakarta.enterprise.context.*

@ApplicationScoped
class AccountDbRepository : PanacheRepository<AccountDb> {

    fun findByAccountNumber(accountNumber: AccountNumber): AccountDb? {
        return find("accountNumber", accountNumber.raw).firstResult()
    }

    fun requireByAccountNumber(accountNumber: AccountNumber): AccountDb {
        return find("accountNumber", accountNumber.raw).singleResult()
    }
}
package example.bankdata.feature.account.service

import example.bankdata.database.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import jakarta.enterprise.context.*

@ApplicationScoped
class AccountService(
    val db: InMemoryDbService
) {

    fun addAccount(domain: AccountDomain) {
        db.addAccount(domain)
    }
}
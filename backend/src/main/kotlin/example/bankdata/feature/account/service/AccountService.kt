package example.bankdata.feature.account.service

import example.bankdata.database.account.services.*
import example.bankdata.models.account.domain.*
import jakarta.enterprise.context.*
import example.bankdata.models.account.domain.AccountDomain

@ApplicationScoped
class AccountService(
    val db: AccountDbService
) {

    fun addAccount(domain: AccountDomain) {
        db.addAccount(domain)
    }
}
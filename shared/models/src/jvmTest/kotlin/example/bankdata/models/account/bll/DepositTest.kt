package models.account.bll

import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.domain.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.math.*

class DepositTest {
    val testAccount = AccountDomain(
        accountNumber = AccountNumber("1234567890"),
        balance = DkkCurrencyDomain(BigDecimal("42")),
        user = AccountUserDomain(firstName = "", lastName = "")
    )

    @Test
    fun testDeposit() {
        val startingAccount: AccountDomain = testAccount.copy(
            balance = DkkCurrencyDomain(BigDecimal("0"))
        )

        val afterDeposit: AccountDomain = startingAccount.deposit(
            DkkCurrencyDomain(BigDecimal("1"))
        )

        assertEquals(BigDecimal("1"), afterDeposit.balance.amount)
    }
}
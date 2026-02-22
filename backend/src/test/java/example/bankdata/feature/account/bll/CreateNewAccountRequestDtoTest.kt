package example.bankdata.feature.account.bll

import example.bankdata.feature.account.models.*
import example.bankdata.models.account.*
import example.bankdata.models.account.domain.*
import example.bankdata.models.currency.dto.*
import example.bankdata.models.general.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class CreateNewAccountRequestDtoTest {

    @Test
    fun toDomain() {
        val domain: AccountDomain = CreateNewAccountRequestDto(
            firstName = "TestFirst",
            lastName = "TestLast",
            startingBalance = DkkCurrencyDto("42".toBigDecimalAsString())
        ).toDomain(newAccountNumber = AccountNumber("1234"))

        assertEquals("1234", domain.accountNumber.raw)

        assertEquals("TestFirst", domain.user.firstName)
        assertEquals("TestLast", domain.user.lastName)

        assertEquals("42".toBigDecimal(), domain.balance.amount)
    }
}
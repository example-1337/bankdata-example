package example.bankdata.models.account.bll

import example.bankdata.models.account.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class NewFromUuidTest {
    @Test
    fun testNewFromUuid() {
        val first: AccountNumber = AccountNumber.newFromUuid()
        val second: AccountNumber = AccountNumber.newFromUuid()
        assertNotEquals(first, second)
    }
}
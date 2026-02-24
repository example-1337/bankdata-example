package example.bankdata.feature.money.resource

import example.bankdata.models.account.*
import example.bankdata.testHelpers.*
import io.quarkus.test.junit.*
import io.restassured.RestAssured.*
import io.restassured.response.*
import example.bankdata.models.account.AccountNumber
import org.hamcrest.*
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.*

@QuarkusTest
@Tag("integration")
class MoneyResourceTest {

    @Test
    fun canGetBalance() {
        val account: AccountNumber = setupNewAccount(startingBalance = "42.00")

        val response: ValidatableResponse = callGetBalance(account)
        response
            .statusCode(200)
            .body(amountIs("42.00"))
    }

    @Test
    fun canDeposit() {
        val account: AccountNumber = setupNewAccount(startingBalance = "0")
        given()
            .json("{\"to\": \"${account.raw}\",\"money\": {\"amount\": \"9000.00\"}}")
            .postThen("/money/deposit")
            .statusCode(200)

        val balanceResponse: ValidatableResponse = callGetBalance(account)
        balanceResponse
            .statusCode(200)
            .body(amountIs("9000.00"))
    }

    @Test
    fun canTransfer() {
        val fromAccount: AccountNumber = setupNewAccount(startingBalance = "100.00")
        val toAccount: AccountNumber = setupNewAccount(startingBalance = "0.00")

        given()
            .json("{\"from\": \"${fromAccount.raw}\",\"to\": \"${toAccount.raw}\",\"money\": {\"amount\": \"100\"}}")
            .postThen("/money/transfer")
            .statusCode(200)
            .body(containsString("Success"))

        callGetBalance(fromAccount)
            .statusCode(200)
            .body(amountIs("0.00"))

        callGetBalance(toAccount)
            .statusCode(200)
            .body(amountIs("100.00"))
    }

    private fun callGetBalance(accountNumber: AccountNumber): ValidatableResponse {
        return given()
            .get("/money/balance/{accountId}", accountNumber.raw)
            .then()
    }

    private fun setupNewAccount(startingBalance: String): AccountNumber {
        val newAccountGuid: String = given()
            .json("{\"firstName\": \"firstName\",\"lastName\": \"lastName\",\"startingBalance\": {\"amount\": \"$startingBalance\"}}")
            .postThen("/account/create")
            .extract()
            .body()
            .asString()
        return AccountNumber(newAccountGuid)
    }

    private fun amountIs(expectedAmount: String): Matcher<String> {
        return containsString("\"amount\":\"$expectedAmount\"")
    }
}
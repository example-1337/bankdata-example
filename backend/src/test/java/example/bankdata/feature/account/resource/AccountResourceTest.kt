package example.bankdata.feature.account.resource

import example.bankdata.testHelpers.*
import io.quarkus.test.junit.*
import io.restassured.RestAssured.*
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.*

@QuarkusTest
@Tag("integration")
class AccountResourceTest {
    @Test
    fun canCreateNewAccount() {
        given()
            .json("{ \"firstName\": \"firstName\", \"lastName\": \"lastName\", \"startingBalance\": { \"amount\": \"42\" } }")
            .postThen("/account/create")

            .statusCode(200)
            .body(containsString("-"))
    }

    @Test
    fun failsCreatingInvalidAccount() {
        given()
            .json("{\"no fields :)\": true}")
            .postThen("/account/create")
            .statusCode(500)

    }
}
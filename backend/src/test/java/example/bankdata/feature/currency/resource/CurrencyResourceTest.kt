package example.bankdata.feature.currency.resource

import example.bankdata.testHelpers.*
import io.quarkus.test.junit.*
import io.restassured.RestAssured.*
import org.hamcrest.Matchers.*
import org.hamcrest.core.*
import org.junit.jupiter.api.*

@QuarkusTest
@Tag("integration")
class CurrencyResourceTest {
    @Test
    fun testConvertDkkToUsd() {
        given()
            .json("{\"dkk\": \"20\"}")
            .postThen("/currency/dkkToUsd")

            .statusCode(200)
            .body(
                AllOf(
                    containsString("\"dkk\":\"20\""),
                    containsString("\"usd\":\"")
                )
            )
    }
}


package example.bankdata.testHelpers

import io.restassured.response.*
import io.restassured.specification.*
import org.intellij.lang.annotations.*

fun RequestSpecification.json(@Language("JSON") json: String): RequestSpecification {
    return body(json)
        .header(
            /* headerName = */ "Content-Type",
            /* headerValue = */ "application/json"
        )
}

fun RequestSpecification.postThen(path: String): ValidatableResponse {
    return post(path)
        .then()
}

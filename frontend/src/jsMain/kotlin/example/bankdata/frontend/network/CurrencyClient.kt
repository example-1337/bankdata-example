package example.bankdata.frontend.network

import example.bankdata.frontend.utils.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import web.http.*

object CurrencyClient {

    @Serializable
    data class ConvertCurrencyDkkToUsdResponse(
        val dkk: String?,
        val usd: String?
    )

    suspend fun convertDkkToUsd(dkk: String): ConvertCurrencyDkkToUsdResponse {

        val response: Response = fetchPostJson(
            url = "http://localhost:8080/currency/dkkToUsd",
            json = "{\"dkk\": \"$dkk\"}"
        )
        val json: String = response.text()
        return Json.decodeFromString(ConvertCurrencyDkkToUsdResponse.serializer(), json)
    }
}
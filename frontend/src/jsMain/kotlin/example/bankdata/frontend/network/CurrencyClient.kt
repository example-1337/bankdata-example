package example.bankdata.frontend.network

import example.bankdata.frontend.utils.fetchPostJson
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import web.http.Response
import web.http.text

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
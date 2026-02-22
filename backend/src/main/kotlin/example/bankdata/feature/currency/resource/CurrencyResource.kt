package example.bankdata.feature.currency.resource

import example.bankdata.feature.currency.bll.*
import example.bankdata.feature.currency.models.*
import example.bankdata.feature.currency.repository.*
import example.bankdata.models.general.*
import jakarta.ws.rs.*
import java.math.*

@Path("/currency")
class CurrencyResource(
    private val repository: CurrencyRepository
) {

    //TODO consider precision
    @Path("/dkkToUsd")
    @POST
    suspend fun convertDkkToUsd(
        request: ConvertCurrencyDkkToUsdRequest
    ): ConvertCurrencyDkkToUsdResponse {
        val dkk: BigDecimalAsString = request.dkk
        val usd: BigDecimal = with(repository) {
            convertDkkToUsd(dkk = dkk)
        }.getOrThrow()

        return ConvertCurrencyDkkToUsdResponse.from(dkk = dkk, usd = usd)
    }
}



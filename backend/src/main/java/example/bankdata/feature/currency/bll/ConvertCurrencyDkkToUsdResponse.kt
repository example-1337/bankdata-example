package example.bankdata.feature.currency.bll

import example.bankdata.feature.currency.models.*
import example.bankdata.models.general.*
import java.math.*

fun ConvertCurrencyDkkToUsdResponse.Companion.from(
    dkk: BigDecimalAsString,
    usd: BigDecimal
): ConvertCurrencyDkkToUsdResponse {
    return ConvertCurrencyDkkToUsdResponse(
        dkk = dkk.value,
        usd = usd.toPlainString()
    )
}
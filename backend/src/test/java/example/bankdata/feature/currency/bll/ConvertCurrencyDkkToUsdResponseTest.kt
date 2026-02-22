package example.bankdata.feature.currency.bll

import example.bankdata.feature.currency.models.ConvertCurrencyDkkToUsdResponse
import example.bankdata.models.general.toBigDecimalAsString
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConvertCurrencyDkkToUsdResponseTest {
    @Test
    fun canMap() {
        val mapped: ConvertCurrencyDkkToUsdResponse = ConvertCurrencyDkkToUsdResponse.from(
            dkk = "45".toBigDecimalAsString(),
            usd = "700".toBigDecimal()
        )

        assertEquals("45", mapped.dkk)
        assertEquals("700", mapped.usd)
    }

}
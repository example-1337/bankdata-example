package example.bankdata.feature.currency.bll

import example.bankdata.feature.currency.models.*
import example.bankdata.models.general.*
import org.junit.jupiter.api.Test
import kotlin.test.*

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
package example.bankdata.services.eurofxref.models.domain.currencies

import org.junit.jupiter.api.Test
import java.math.*
import kotlin.test.*

class CurrencyConverterDomainTest {


    class Convert {
        @Test
        fun convert1To1() {
            val converter = CurrencyConverterDomain(
                fromRate = BigDecimal("1.0"),
                toRate = BigDecimal("1.0")
            )

            val result: BigDecimal = converter.convert(BigDecimal("1.0"))

            assertEquals(expected = 1.0, actual = result.toDouble(), absoluteTolerance = 0.01)
        }

        @Test
        fun convertDkkToUsdExample() {
            val dkkRate = BigDecimal("7.4716")
            val usdRate = BigDecimal("1.1767")

            val converter = CurrencyConverterDomain(
                fromRate = dkkRate,
                toRate = usdRate
            )

            val result: BigDecimal = converter.convert(BigDecimal("20.0"))

            val resultWith2Decimals: String = result.setScale(2, RoundingMode.HALF_UP).toPlainString()
            assertEquals(expected = "3.15", actual = resultWith2Decimals)
        }
    }
}
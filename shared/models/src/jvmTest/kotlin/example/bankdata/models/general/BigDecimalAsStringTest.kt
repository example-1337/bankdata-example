package models.general

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.math.*

class BigDecimalAsStringTest {

    @Test
    fun toBigDecimal() {
        val valid: BigDecimal = "123".toBigDecimalAsString().toBigDecimal()
        assertEquals("123".toBigDecimal(), valid)

        assertThrows<Throwable> {
            "test".toBigDecimalAsString().toBigDecimal()
        }
    }

    @Test
    fun bigDecimalToBigDecimalAsString() {
        val mapped: BigDecimalAsString = "8000".toBigDecimal().toBigDecimalAsString()
        assertEquals("8000".toBigDecimalAsString(), mapped)
    }

    @Test
    fun stringToBigDecimalAsString() {
        assertEquals("100", "100".toBigDecimalAsString().value)
    }
}
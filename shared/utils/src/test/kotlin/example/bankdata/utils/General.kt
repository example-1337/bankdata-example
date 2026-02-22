package example.bankdata.utils

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class General {
    @Test
    fun shouldProduceCorrectClass() {
        assertEquals(General::class.java, jvmType<General>())
    }
}
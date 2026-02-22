package example.bankdata.utils.system

import kotlinx.coroutines.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import kotlin.time.Duration.Companion.milliseconds

class SystemNanoTimeTest {

    class IsAfter {

        @Test
        fun shouldCompareValueByGreaterThan() {
            assertTrue(SystemNanoTime(200).isAfter(SystemNanoTime(100)))
            assertTrue(SystemNanoTime(200).isAfter(SystemNanoTime(199)))

            assertFalse(SystemNanoTime(200).isAfter(SystemNanoTime(200)))
        }
    }


    @Test
    fun now() = runBlocking {
        val first: SystemNanoTime = SystemNanoTime.now()
        delay(50.milliseconds)
        val second: SystemNanoTime = SystemNanoTime.now()

        val isSecondAfterFirst: Boolean = second.isAfter(first)
        assertTrue(isSecondAfterFirst)
    }

}
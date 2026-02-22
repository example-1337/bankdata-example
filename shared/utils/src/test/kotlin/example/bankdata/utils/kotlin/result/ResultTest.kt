package example.bankdata.utils.kotlin.result

import example.bankdata.testhelpers.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class ResulTest {

    class ValueOrOnFailureTest {

        @Test
        fun onSuccess() {
            val value: Int = Result.success(42).valueOrOnFailure { shouldNotBeCalled() }
            assertEquals(42, value)
        }

        @Test
        fun onFailure() {
            assertThrows<IllegalArgumentException> {
                Result.failure<Int>(IllegalArgumentException("bad arg")).valueOrOnFailure { it: Throwable ->
                    throw it
                }
            }
        }
    }

}
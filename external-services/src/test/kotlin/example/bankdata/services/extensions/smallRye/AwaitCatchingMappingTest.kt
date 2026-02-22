package  example.bankdata.services.extensions.smallRye

import io.smallrye.mutiny.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class AwaitCatchingMappingTest {
    @Test
    fun mapWorks() = runTest {
        val result: Result<Int> = uni { 42 }.awaitCatchingMapping { it: Int ->
            assertEquals(42, it)
            100
        }

        assertEquals(100, result.getOrThrow())
    }

    @Test
    fun catchesExceptions() = runTest {
        val result: Result<Nothing> = uni { "test" }.awaitCatchingMapping { it: String ->
            assertEquals("test", it)
            throw RuntimeException("simulated")
        }

        assertTrue(result.isFailure)
        assertEquals("simulated", result.exceptionOrNull()?.message)
    }
}
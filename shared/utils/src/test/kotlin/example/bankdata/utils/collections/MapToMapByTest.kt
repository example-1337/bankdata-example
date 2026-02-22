package example.bankdata.utils.collections

import example.bankdata.testhelpers.*
import example.bankdata.testhelpers.collections.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class MapToMapByTest {

    @Test
    fun empty() {
        val list: List<String> = listOf()
        val result: Map<Nothing, Nothing> = list.mapToMapBy(
            keyMapper = { shouldNotBeCalled() },
            valueMapper = { shouldNotBeCalled() }
        )
        assertEmpty(result)
    }

    @Test
    fun mapsSingle() {
        val list: List<String> = listOf("test")
        val result: Map<String, String> = list.mapToMapBy(
            keyMapper = { "key" },
            valueMapper = { "value" }
        )
        assertSingleByEquals(map = result, key = "key", value = "value")
    }

    @Test
    fun mapsMultiple() {
        val list: List<String> = listOf("test", "1234")
        val result: Map<String, String> = list.mapToMapBy(
            keyMapper = { it },
            valueMapper = { it }
        )
        assertEquals(2, result.size)
    }

    @Test
    fun duplicatedKeysOverwrite() {
        val list: List<String> = listOf("test", "1234", "test")
        val result: Map<String, String> = list.mapToMapBy(
            keyMapper = { it },
            valueMapper = { it }
        )
        assertEquals(2, result.size)
        assertEquals(1, result.count { it.key == "test" })
    }

}
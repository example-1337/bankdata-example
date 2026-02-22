package example.bankdata.testhelpers.collections

import kotlin.test.*

fun assertEmpty(map: Map<*, *>) {
    assertEquals(expected = 0, actual = map.size, message = "Map should be empty")
}
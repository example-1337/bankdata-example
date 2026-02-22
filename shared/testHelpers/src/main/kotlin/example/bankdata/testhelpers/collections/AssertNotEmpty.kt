package example.bankdata.testhelpers.collections

import kotlin.test.*

fun assertNotEmpty(map: Map<*, *>) {
    assertNotEquals(0, map.size)
}
package example.bankdata.testhelpers.collections

import kotlin.test.*

fun <Key, Value> assertSingleByEquals(map: Map<Key, Value>, key: Key, value: Value) {
    assertEquals(expected = 1, actual = map.size, message = "Map should have a single element, but has ${map.size}")

    assertTrue(actual = map.containsKey(key), message = "Map was expected to have key = $key")
    assertEquals(expected = value, actual = map[key])
}
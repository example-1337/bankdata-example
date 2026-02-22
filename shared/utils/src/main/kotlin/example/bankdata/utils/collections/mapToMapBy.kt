package example.bankdata.utils.collections

fun <Element, Key, Value> List<Element>.mapToMapBy(
    keyMapper: (Element) -> Key,
    valueMapper: (Element) -> Value
): Map<Key, Value> {
    val result: MutableMap<Key, Value> = mutableMapOf()

    this.forEach { element ->
        val key: Key = keyMapper(element)
        val value: Value = valueMapper(element)
        result[key] = value
    }

    return result
}
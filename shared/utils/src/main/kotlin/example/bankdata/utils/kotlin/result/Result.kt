package example.bankdata.utils.kotlin.result

inline fun <Value> Result<Value>.valueOrOnFailure(
    onFailure: (failed: Throwable) -> Nothing
): Value {
    val value: Value? = getOrNull()
    if (value != null) {
        return value
    }

    val exception: Throwable? = exceptionOrNull()
    if (exception != null) {
        onFailure(exception)
    }

    throw IllegalStateException("Impossible state, should use compiler better :)2")
}
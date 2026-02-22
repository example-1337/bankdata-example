package example.bankdata.testhelpers.result

fun <T> Result.Companion.notSetFailure(): Result<T> {
    return Result.failure(RuntimeException("Value not set"))
}
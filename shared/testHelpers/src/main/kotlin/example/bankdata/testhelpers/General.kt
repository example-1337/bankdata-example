package example.bankdata.testhelpers

fun shouldNotBeCalled(): Nothing {
    throw AssertionError("should not be called")
}
package example.bankdata.utils

inline fun <reified T> jvmType(): Class<T> {
    return T::class.java
}
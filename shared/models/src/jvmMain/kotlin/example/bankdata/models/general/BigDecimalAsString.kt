package example.bankdata.models.general

import kotlinx.serialization.*
import java.math.*


@Serializable
@JvmInline
value class BigDecimalAsString(
    val value: String
) {
    fun toBigDecimal(): BigDecimal {
        return BigDecimal(value)
    }

    companion object
}

fun BigDecimal.toBigDecimalAsString(): BigDecimalAsString {
    return BigDecimalAsString(this.toPlainString())
}

fun String.toBigDecimalAsString(): BigDecimalAsString {
    return BigDecimalAsString(this)
}
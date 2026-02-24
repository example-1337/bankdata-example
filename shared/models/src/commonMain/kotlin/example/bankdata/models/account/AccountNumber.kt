package example.bankdata.models.account

import kotlinx.serialization.*
import kotlin.jvm.*

@Serializable
@JvmInline
value class AccountNumber(val raw: String) {
    companion object
}
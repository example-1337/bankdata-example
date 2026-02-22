package example.bankdata.models.account

import kotlinx.serialization.*

@Serializable
@JvmInline
value class AccountNumber(val raw: String) {
    companion object
}
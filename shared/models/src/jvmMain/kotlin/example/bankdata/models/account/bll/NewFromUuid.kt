@file:OptIn(ExperimentalUuidApi::class)

package example.bankdata.models.account.bll

import example.bankdata.models.account.*
import kotlin.uuid.*


fun AccountNumber.Companion.newFromUuid(): AccountNumber {
    val uuid: Uuid = Uuid.random()
    return AccountNumber(uuid.toHexDashString())
}

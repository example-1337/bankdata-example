@file:OptIn(ExperimentalContracts::class)

package example.bankdata.utils.cache

import example.bankdata.utils.system.*
import kotlin.contracts.*
import kotlin.time.*

class TimedAsyncCache<T>(
    private val cacheDuration: Duration,
    private val getSystemTime: () -> SystemNanoTime = SystemNanoTime::now
) {
    private var value: T? = null
    private var expireAt: SystemNanoTime? = null

    suspend fun valueIfValidOrUpdateWith(action: suspend () -> T): T {
        val value: T? = value
        if (value != null && hasNotExpired()) {
            return value
        }
        return action().also { updateCacheWith(it) }
    }

    private fun updateCacheWith(newValue: T) {
        this.value = newValue
        expireAt = getSystemTime() + cacheDuration
    }

    private fun hasNotExpired(): Boolean {
        return expireAt?.isAfter(getSystemTime()) == true
    }
}
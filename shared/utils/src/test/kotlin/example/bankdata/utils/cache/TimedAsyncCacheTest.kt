package example.bankdata.utils.cache

import example.bankdata.testhelpers.coroutines.*
import example.bankdata.utils.system.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.test.*
import kotlin.time.Duration.Companion.seconds

class TimedAsyncCacheTest {

    class ValueIfValidOrUpdateWith {
        @Test
        fun shouldStartEmpty() = runBlocking {
            var callCount = 0
            val cache = TimedAsyncCache<Int>(cacheDuration = 10.seconds)

            val value: Int = cache.valueIfValidOrUpdateWith { callCount++; 42 }

            assertEquals(42, value)
            assertEquals(1, callCount)
        }

        @Test
        fun shouldNotUpdateWhenCached() = runTest {
            var callCount = 0
            val cache = TimedAsyncCache<Int>(
                cacheDuration = 1.seconds,
                getSystemTime = { SystemNanoTime(currentNanoTime) }
            )

            suspend fun callCache() {
                cache.valueIfValidOrUpdateWith { callCount++; 42 }
            }

            callCache()
            callCache()
            callCache()
            assertEquals(1, callCount)

        }

        @Test
        fun shouldCallAfterCacheExpires() = runTest {
            var callCount = 0
            val cache = TimedAsyncCache<Int>(
                cacheDuration = 1.seconds,
                getSystemTime = { SystemNanoTime(currentNanoTime) }
            )

            suspend fun callCache() {
                cache.valueIfValidOrUpdateWith { callCount++; 42 }
            }

            callCache()
            assertEquals(1, callCount)

            delay(1.seconds)

            callCache()
            assertEquals(2, callCount)
        }
    }
}

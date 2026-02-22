@file:OptIn(ExperimentalCoroutinesApi::class)

package example.bankdata.testhelpers.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

val TestScope.currentNanoTime: Long
    get() = currentTime * 1_000_000
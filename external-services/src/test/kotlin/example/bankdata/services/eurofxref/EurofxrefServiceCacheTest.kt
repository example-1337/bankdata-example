package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.testhelpers.coroutines.*
import example.bankdata.utils.system.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Test
import kotlin.test.*
import kotlin.time.Duration.Companion.days

class EurofxrefServiceCacheTest {

    @Test
    fun exceptionsAreCaught() = runTest {
        val mock = EurofxrefServiceMocked()
        mock.dailyCurrenciesResult = Result.failure(RuntimeException("failure"))
        val cache = EurofxrefServiceCache(mock)
        val result: Result<EurofxrefDailyCurrenciesDomain> = cache.dailyCurrencies()

        assertTrue(result.isFailure)
    }

    @Test
    fun successGetsCached() = runTest {
        val mock = EurofxrefServiceMocked()
        mock.dailyCurrenciesResult = Result.success(EurofxrefDailyCurrenciesDomain(currencies = mapOf()))

        val cache = EurofxrefServiceCache(mock)

        val result: Result<EurofxrefDailyCurrenciesDomain> = cache.dailyCurrencies()

        assertTrue(result.isSuccess)
        assertEquals(1, mock.dailyCurrenciesCallCount)

        cache.dailyCurrencies()
        assertEquals(1, mock.dailyCurrenciesCallCount, message = "should use cache")
    }

    @Test
    fun cacheShouldExpireAfterADay() = runTest {
        val mock = EurofxrefServiceMocked()
        mock.dailyCurrenciesResult = Result.success(EurofxrefDailyCurrenciesDomain(currencies = mapOf()))
        val cache = EurofxrefServiceCache(mock, getSystemTime = { SystemNanoTime(currentNanoTime) })

        cache.dailyCurrencies()
        assertEquals(1, mock.dailyCurrenciesCallCount)

        delay(1.days)

        cache.dailyCurrencies()
        assertEquals(2, mock.dailyCurrenciesCallCount)
    }

}
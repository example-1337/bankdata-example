package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.testhelpers.result.*

class EurofxrefServiceMocked : EurofxrefService {
    var dailyCurrenciesResult: Result<EurofxrefDailyCurrenciesDomain> = Result.notSetFailure()
    var dailyCurrenciesCallCount: Int = 0
        private set

    override suspend fun dailyCurrencies(): Result<EurofxrefDailyCurrenciesDomain> {
        dailyCurrenciesCallCount += 1
        return dailyCurrenciesResult
    }
}
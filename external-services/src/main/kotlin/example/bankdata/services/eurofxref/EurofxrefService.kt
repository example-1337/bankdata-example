package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.models.domain.currencies.*

interface EurofxrefService {
    suspend fun dailyCurrencies(): Result<EurofxrefDailyCurrenciesDomain>
}

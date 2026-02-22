package example.bankdata.services.eurofxref.models.domain.currencies

import example.bankdata.models.general.*

data class EurofxrefDailyCurrenciesDomain(
    val currencies: Map<String, BigDecimalAsString>
)
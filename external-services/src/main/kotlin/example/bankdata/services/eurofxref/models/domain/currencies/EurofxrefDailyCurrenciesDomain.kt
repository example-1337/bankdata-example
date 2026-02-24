package example.bankdata.services.eurofxref.models.domain.currencies

import example.bankdata.models.general.*
import example.bankdata.models.general.BigDecimalAsString

data class EurofxrefDailyCurrenciesDomain(
    val currencies: Map<String, BigDecimalAsString>
)
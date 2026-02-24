package example.bankdata.services.eurofxref.models.domain.currencies.operations

import example.bankdata.models.general.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.models.general.BigDecimalAsString

val EurofxrefDailyCurrenciesDomain.usd: BigDecimalAsString?
    get() = currencies["USD"]
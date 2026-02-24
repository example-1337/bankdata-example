package example.bankdata.services.eurofxref.bll

import example.bankdata.models.general.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.services.eurofxref.models.dto.*
import example.bankdata.utils.collections.*
import example.bankdata.models.general.BigDecimalAsString

fun EurofxrefDailyDto.toDomain(): EurofxrefDailyCurrenciesDomain {
    val currencies: Map<String, BigDecimalAsString> = cube.cube.cube.mapToMapBy(
        keyMapper = EurofxrefDailyEnvelopeCubeDto::currency,
        valueMapper = EurofxrefDailyEnvelopeCubeDto::rate
    )

    return EurofxrefDailyCurrenciesDomain(currencies)
}
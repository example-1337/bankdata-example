package example.bankdata.models.currency.bll

import example.bankdata.models.currency.domain.*
import example.bankdata.models.currency.dto.*
import example.bankdata.models.general.*
import java.math.*

fun DkkCurrencyDto.toDomain(): DkkCurrencyDomain {
    val convertedCurrencyFromRaw: BigDecimal = amount.toBigDecimal()
    return DkkCurrencyDomain(convertedCurrencyFromRaw)
}

fun DkkCurrencyDomain.toCurrencyDto(): CurrencyDto {
    return CurrencyDto(
        currencyType = unitRepresentation,
        amount = amount.toBigDecimalAsString()
    )
}
package example.bankdata.models.currency.domain

import java.math.*

sealed interface CurrencyDomain {
    val amount: BigDecimal
    val unitRepresentation: String
}
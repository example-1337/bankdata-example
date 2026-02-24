package example.bankdata.models.currency.domain

import java.math.*


data class DkkCurrencyDomain(
    override val amount: BigDecimal
) : CurrencyDomain {
    override val unitRepresentation: String = DkkCurrencyDomain.unitRepresentation

    operator fun plus(other: DkkCurrencyDomain): DkkCurrencyDomain {
        return DkkCurrencyDomain(amount + other.amount)
    }

    operator fun minus(other: DkkCurrencyDomain): DkkCurrencyDomain {
        return DkkCurrencyDomain(amount - other.amount)
    }

    operator fun compareTo(other: DkkCurrencyDomain): Int {
        return amount.compareTo(other.amount)
    }

    companion object {
        const val unitRepresentation: String = "DKK"
    }
}

package example.bankdata.models.currency.bll

import example.bankdata.models.currency.domain.*
import example.bankdata.models.currency.dto.*
import example.bankdata.models.general.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class DkkCurrencyTest {

    @Test
    fun dkkCurrencyDtoToDomain() {
        val domain: DkkCurrencyDomain = DkkCurrencyDto(amount = "42".toBigDecimalAsString()).toDomain()
        assertEquals("42".toBigDecimal(), domain.amount)
        assertEquals(DkkCurrencyDomain.unitRepresentation, domain.unitRepresentation)
    }

    @Test
    fun dkkCurrencyDomainToCurrencyDto() {
        val dto: CurrencyDto = DkkCurrencyDomain(amount = "100".toBigDecimal()).toCurrencyDto()
        assertEquals(dto.currencyType, DkkCurrencyDomain.unitRepresentation)
        assertEquals(dto.amount, "100".toBigDecimalAsString())
    }

}
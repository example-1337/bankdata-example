package example.bankdata.services.eurofxref

import example.bankdata.models.general.*
import example.bankdata.services.eurofxref.api.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.testhelpers.collections.*
import io.smallrye.mutiny.*
import example.bankdata.models.general.toBigDecimalAsString
import org.intellij.lang.annotations.*
import org.junit.jupiter.api.Test
import kotlin.test.*

class EurofxrefServiceNetworkTest {

    @Test
    suspend fun canParseValidXml() {
        val service: EurofxrefService = createServiceWith(responseXml = validXmlResponse)
        val result: EurofxrefDailyCurrenciesDomain = service.dailyCurrencies().getOrThrow()
        assertNotEmpty(result.currencies)
        assertContains(result.currencies, "DKK")
        assertContains(result.currencies, "USD")

        assertEquals("1.1767".toBigDecimalAsString(), result.currencies["USD"])
        assertEquals("7.4716".toBigDecimalAsString(), result.currencies["DKK"])
    }

    private fun createServiceWith(@Language("xml") responseXml: String): EurofxrefService {
        return EurofxrefServiceNetwork(createFakeApiWith(responseXml))
    }

    private fun createFakeApiWith(@Language("xml") responseXml: String): EuroxrefApi {
        return object : EuroxrefApi {
            override fun dailyXml(): Uni<String> {
                return uni { responseXml }
            }
        }
    }
}

@Language("xml")
val validXmlResponse: String = """
            <?xml version="1.0" encoding="UTF-8"?>
            <gesmes:Envelope xmlns:gesmes="http://www.gesmes.org/xml/2002-08-01" xmlns="http://www.ecb.int/vocabulary/2002-08-01/eurofxref">
            	<gesmes:subject>Reference rates</gesmes:subject>
            	<gesmes:Sender>
            		<gesmes:name>European Central Bank</gesmes:name>
            	</gesmes:Sender>
            	<Cube>
            		<Cube time='2026-02-20'>
            			<Cube currency='USD' rate='1.1767'/>
            			<Cube currency='JPY' rate='182.63'/>
            			<Cube currency='CZK' rate='24.241'/>
            			<Cube currency='DKK' rate='7.4716'/>
            			<Cube currency='GBP' rate='0.87280'/>
            			<Cube currency='HUF' rate='379.65'/>
            			<Cube currency='PLN' rate='4.2238'/>
            			<Cube currency='RON' rate='5.0978'/>
            			<Cube currency='SEK' rate='10.6745'/>
            			<Cube currency='CHF' rate='0.9132'/>
            			<Cube currency='ISK' rate='144.90'/>
            			<Cube currency='NOK' rate='11.2540'/>
            			<Cube currency='TRY' rate='51.5932'/>
            			<Cube currency='AUD' rate='1.6697'/>
            			<Cube currency='BRL' rate='6.1358'/>
            			<Cube currency='CAD' rate='1.6112'/>
            			<Cube currency='CNY' rate='8.1294'/>
            			<Cube currency='HKD' rate='9.1961'/>
            			<Cube currency='IDR' rate='19872.87'/>
            			<Cube currency='ILS' rate='3.6783'/>
            			<Cube currency='INR' rate='107.0155'/>
            			<Cube currency='KRW' rate='1705.81'/>
            			<Cube currency='MXN' rate='20.2402'/>
            			<Cube currency='MYR' rate='4.5927'/>
            			<Cube currency='NZD' rate='1.9763'/>
            			<Cube currency='PHP' rate='68.428'/>
            			<Cube currency='SGD' rate='1.4931'/>
            			<Cube currency='THB' rate='36.719'/>
            			<Cube currency='ZAR' rate='18.9417'/>
            		</Cube>
            	</Cube>
            </gesmes:Envelope>
        """.trimIndent()



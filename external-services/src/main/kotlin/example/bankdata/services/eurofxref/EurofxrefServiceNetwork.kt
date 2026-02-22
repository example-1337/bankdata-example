package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.api.*
import example.bankdata.services.eurofxref.bll.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.services.eurofxref.models.dto.*
import example.bankdata.services.extensions.smallRye.*
import nl.adaptivity.xmlutil.serialization.*

class EurofxrefServiceNetwork(
    private val api: EuroxrefApi
) : EurofxrefService {
    private val xmlSerializer: XML = XML.recommended_1_0 {
        policy {
            ignoreUnknownChildren()
        }
    }

    override suspend fun dailyCurrencies(): Result<EurofxrefDailyCurrenciesDomain> {
        return api.dailyXml().awaitCatchingMapping { xml: String ->
            xmlSerializer
                .decodeFromString(EurofxrefDailyDto.Companion.serializer(), xml)
                .toDomain()
        }
    }
}
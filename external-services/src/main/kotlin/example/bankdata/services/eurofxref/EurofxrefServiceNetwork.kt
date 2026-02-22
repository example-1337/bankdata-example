package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.api.*
import example.bankdata.services.eurofxref.bll.*
import example.bankdata.services.eurofxref.models.domain.currencies.*
import example.bankdata.services.eurofxref.models.dto.*
import example.bankdata.services.extensions.smallRye.*
import io.smallrye.mutiny.*
import jakarta.enterprise.context.*
import nl.adaptivity.xmlutil.serialization.*
import org.eclipse.microprofile.rest.client.inject.*

@ApplicationScoped
class EurofxrefServiceNetwork(
    @param:RestClient
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
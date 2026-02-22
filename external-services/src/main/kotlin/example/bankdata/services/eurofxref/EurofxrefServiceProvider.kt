package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.api.EuroxrefApi
import example.bankdata.services.eurofxref.models.domain.currencies.*
import jakarta.enterprise.inject.Default
import jakarta.enterprise.inject.Produces
import org.eclipse.microprofile.rest.client.inject.RestClient


object EurofxrefServiceProvider {

    @Produces
    @Default
    fun defaultService(
        @RestClient
        api: EuroxrefApi
    ): EurofxrefService {
        return EurofxrefServiceCache(
            delegate = EurofxrefServiceNetwork(api = api)
        )
    }
}

package example.bankdata.services.eurofxref

import example.bankdata.services.eurofxref.api.*
import jakarta.enterprise.inject.*
import org.eclipse.microprofile.rest.client.inject.*


class EurofxrefServiceProvider {
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

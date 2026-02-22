package example.bankdata.services.eurofxref.api

import io.smallrye.mutiny.*
import jakarta.ws.rs.*
import jakarta.ws.rs.core.*
import org.eclipse.microprofile.rest.client.inject.*

@RegisterRestClient(baseUri = "https://www.ecb.europa.eu")
interface EuroxrefApi {
    @GET
    @Consumes(MediaType.TEXT_XML)
    @Path("/stats/eurofxref/eurofxref-daily.xml")
    fun dailyXml(): Uni<String>
}
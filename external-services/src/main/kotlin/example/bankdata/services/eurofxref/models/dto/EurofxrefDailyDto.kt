package example.bankdata.services.eurofxref.models.dto

import example.bankdata.models.general.*
import jakarta.xml.bind.annotation.*
import kotlinx.serialization.*
import nl.adaptivity.xmlutil.serialization.*
import nl.adaptivity.xmlutil.serialization.XmlElement

private const val ecbNS = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref"
private const val gemesNS = "http://www.gesmes.org/xml/2002-08-01"

@Serializable
@XmlSerialName("Envelope", namespace = gemesNS, prefix = "gesmes")
class EurofxrefDailyDto(
    @XmlElement
    val subject: String,
    val sender: EurofxrefDailyEnvelopeSenderDto,
    val cube: EurofxrefDailyEnvelopeCubeContainerWrapperDto
) {
    companion object
}

@Serializable
@XmlSerialName("Sender", namespace = gemesNS, prefix = "gesmes")
data class EurofxrefDailyEnvelopeSenderDto(
    @XmlElement(true)
    val name: String
) {
    companion object
}

@Serializable
@XmlSerialName("Cube", namespace = ecbNS, prefix = "")
data class EurofxrefDailyEnvelopeCubeContainerWrapperDto(
    val cube: EurofxrefDailyEnvelopeCubeContainerDto
)

@Serializable
@XmlSerialName("Cube", namespace = ecbNS, prefix = "")
data class EurofxrefDailyEnvelopeCubeContainerDto(
    @XmlAttribute("time")
    val time: String,
    @XmlElement(true)
    val cube: List<EurofxrefDailyEnvelopeCubeDto>
) {
    companion object
}

@Serializable
@XmlSerialName("Cube", namespace = ecbNS, prefix = "")
data class EurofxrefDailyEnvelopeCubeDto(
    @XmlAttribute("currency")
    val currency: String,
    @XmlAttribute("rate")
    val rate: BigDecimalAsString
) {
    companion object
}


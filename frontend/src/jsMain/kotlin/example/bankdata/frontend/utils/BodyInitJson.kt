package example.bankdata.frontend.utils

import org.intellij.lang.annotations.*
import web.http.*

fun BodyInitJson(
    @Language("json")
    json: String
): BodyInit {
    return BodyInit(json)
}
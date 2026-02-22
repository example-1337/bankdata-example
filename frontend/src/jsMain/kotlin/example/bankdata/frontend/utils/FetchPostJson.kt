package example.bankdata.frontend.utils

import org.intellij.lang.annotations.*
import web.http.*

suspend fun fetchPostJson(
    url: String,
    @Language("json")
    json: String
): Response {
    val request = RequestInit(
        method = RequestMethod.POST,
        body = BodyInitJson(json = json),
        headers = Headers().apply {
            set("content-type", "application/json;charset=UTF-8")
        },
    )
    return fetch(url, request)
}
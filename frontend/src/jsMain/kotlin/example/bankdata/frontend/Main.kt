package example.bankdata.frontend

import react.*
import react.dom.client.*
import web.dom.*
import web.html.*

fun main() {
    val container: HTMLElement = document.getElementById(ElementId("root"))
        ?: error("Couldn't find root container!")
    val rooted: Root = createRoot(container)
    rooted.render(App.create())
}


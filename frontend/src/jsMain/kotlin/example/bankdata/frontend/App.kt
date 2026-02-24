package example.bankdata.frontend

import example.bankdata.frontend.network.*
import example.bankdata.models.account.AccountNumber
import kotlinx.coroutines.*
import react.*
import react.dom.events.*
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.p
import web.cssom.*
import web.html.*

val mainScope: CoroutineScope = MainScope()
val exampleModelFromShared = AccountNumber("test")

val App: FC<Props> = FC {


    h1 {
        +"Online Exchange"
    }

    h3 {
        +"Convert DKK to USD"
    }

    p {
        +"Enter DKK"
    }
    ConvertComponent {

    }

    p{
        +"${exampleModelFromShared}"
    }
}

val ConvertComponent: FC<Props> = FC {
    var dkk: String? by useState()
    var result: String? by useState()
    var isSpinning: Boolean by useState(false)

    input {
        type = InputType.number
        onChange = { it: ChangeEvent<HTMLInputElement, HTMLInputElement> ->
            dkk = it.target.value
        }
    }

    button {
        +"Convert"
        onClick = {
            result = null
            isSpinning = true
            mainScope.launch {
                delay(1000)
                result = CurrencyClient.convertDkkToUsd(dkk ?: "0").usd
                isSpinning = false
            }
        }
    }
    if (result != null) {
        p {
            +"${dkk},- DKK in USD is $result$"
        }
    }
    if (isSpinning) {
        div {
            className = ClassName("loader")
        }
    }
}

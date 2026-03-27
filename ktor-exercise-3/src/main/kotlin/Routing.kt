package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

@Serializable
data class Stock(val symbol: String, val price: Double) {
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Server is online at Lehman College.")
        }
        get("/greet/{name}") {
            call.respondText("Hello ${call.parameters["name"]}! Welcome to CMP 269.")
        }
        get("/grade/{studentId}"){
            val studentId = mapOf("123" to 95, "456" to 82)
            if(studentId.containsKey(call.parameters["studentId"])) {
                call.respond("${studentId[call.parameters["studentId"]]}")
            } else {
                call.respondText("Student not found.", status = HttpStatusCode.NotFound)
            }
        }
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
        get("/api/stock/{symbol}") {
            val symbol  = call.parameters["symbol"] !!
            val stockv2 = Stock(symbol, 150.25)
            call.respond(stockv2)
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}

package pl.edu.uj.android

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import pl.edu.uj.backend.products.customerRoutes
import org.jetbrains.exposed.sql.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    //Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")
    Database.connect("jdbc:sqlite:/data.db", "org.sqlite.JDBC")
    customerRoutes()

    routing {

        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}


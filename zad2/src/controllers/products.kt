package pl.edu.uj.backend.products


import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import pl.edu.uj.backend.models.products.*
import org.jetbrains.exposed.sql.*

fun Route.products(){
    get("/products") {
        val products = Products.selectAll()
        call.respond(products)
    }

    post("/addproduct") {
        val product = call.receive<Products>()
        call.response(product)
    }
}

fun Application.customerRoutes() {
    routing {
        products()
    }
}
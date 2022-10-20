package pl.edu.uj.backend.models.products

import org.jetbrains.exposed.sql.*
import com.rnett.exposedgson.*

object Products : Table() {
    val id = integer("id").autoIncrement() // Column<Int>
    val title = varchar("title", 50) // Column<String>

    override val primaryKey = PrimaryKey(id, name = "PK_Products_ID")
}

@JsonAdapter(ExposedTypeAdapter::class)
class ProductsData(id: EntityID<Int>) : IntEntity(id) {
    @ExposedGSON.JsonName("title")
    var title by Products.title
}

//data class ProductsData(val id: Int, val title: String)

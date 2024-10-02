import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import ru.otus.db.University
import ru.otus.models.UniversityInfo

suspend fun fetchAndStoreUniversities(countrySearch: String) {
    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json()
        }
    }

    val response = client.get("http://universities.hipolabs.com/search?country=$countrySearch%20Federation").bodyAsText()
    val universities: List<UniversityInfo> = Json.decodeFromString(response)

    transaction {
        universities.forEach { university ->
            University.insert {
                it[name] = university.name
                it[domains] = university.domains
                it[webPages] = university.webPages
                it[country] = university.country
                it[alphaTwoCode] = university.alphaTwoCode
            }
        }
    }
}
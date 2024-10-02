package ru.otus.service

import fetchAndStoreUniversities
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.Database
import ru.otus.entity.searchUniversities

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/university",
        driver = "org.postgresql.Driver",
        user = "otus",
        password = "otus")

    println("Введите название страны:")
    val country = readlnOrNull() ?: return

    runBlocking {
        fetchAndStoreUniversities(country)
    }

    while (true) {
        println("Введите название университета для поиска (или 'exit' для выхода):")
        val query = readlnOrNull() ?: break
        if (query.lowercase() == "exit") break

        val results = searchUniversities(query)
        if (results.isEmpty()) {
            println("Университеты не найдены.")
        } else {
            results.forEach { println(it) }
        }
    }
}
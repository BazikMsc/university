package ru.otus.entity

import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import ru.otus.db.University
import ru.otus.models.UniversityInfo

fun searchUniversities(query: String): List<UniversityInfo> {
    return transaction {
        University.selectAll().where {
            (University.name like "%$query%") or (University.country like "%$query%")
        }.map {
            UniversityInfo(
                it[University.domains],
                it[University.alphaTwoCode],
                it[University.webPages],
                it[University.name],
                it[University.stateProvince],
                it[University.country]
            )
        }.toList()
    }
}
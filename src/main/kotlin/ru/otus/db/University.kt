package ru.otus.db

import org.jetbrains.exposed.sql.Table

object University : Table("university") {
    val domains = array<String>("domains")
    val alphaTwoCode = varchar("alpha_two_code", 2)
    val webPages =  array<String>("web_pages")
    val name = varchar("name", 255)
    val stateProvince = varchar("state_province", 255).nullable()
    val country = varchar("country", 255)
}

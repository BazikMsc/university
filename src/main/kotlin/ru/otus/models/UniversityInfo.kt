package ru.otus.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UniversityInfo(
    val domains: List<String>,
    @SerialName("alpha_two_code") val alphaTwoCode: String,
    @SerialName("web_pages") val webPages: List<String>,
    val name: String,
    @SerialName("state-province") val stateProvince: String? = null,
    val country: String

)

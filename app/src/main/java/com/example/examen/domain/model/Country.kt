package com.example.examen.domain.model

data class Country(
    val name: String,
    val officialName: String,
    val flagUrl: String,
    val capital: String?,
    val region: String?,
    val subregion: String?,
    val population: Int?,
    val area: Double?,
    val borders: List<String>?
)
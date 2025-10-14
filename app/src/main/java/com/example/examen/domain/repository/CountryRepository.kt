package com.app.countryapp.domain.repository

import com.example.examen.domain.model.Country


interface CountryRepository {
    suspend fun getCountryList(): List<Country>

    suspend fun getCountryByName(name: String): Country
}
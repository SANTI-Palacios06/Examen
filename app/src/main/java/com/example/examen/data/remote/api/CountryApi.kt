package com.example.examen.data.remote.api

import CountryDetailDto
import com.example.examen.data.remote.dto.CountryListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApi {
    @GET("all")
    suspend fun getCountryList(
        @Query("fields") fields: String = "name"
    ): List<CountryListDto>

    @GET("name/{countryName}")
    suspend fun getCountry(@Path("countryName") countryName: String): List<CountryDetailDto>
}
package com.app.countryapp.data.remote.api


import CountryDetailDto
import com.app.countryapp.data.remote.dto.CountryListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApi {
    @GET("all")
    suspend fun getCountryList(
        @Query("fields") fields: String = "name,flags,capital,region,population"
    ): List<CountryListDto>

    @GET("name/{countryName}")
    suspend fun getCountry(@Path("countryName") countryName: String): List<CountryDetailDto>
}
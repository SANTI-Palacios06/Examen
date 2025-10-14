package com.app.countryapp.data.remote.dto

import com.example.examen.data.remote.dto.CountryNameDto
import com.google.gson.annotations.SerializedName

data class CountryListDto(
    @SerializedName("name") val name: CountryNameDto,
    @SerializedName("flags") val flags: FlagsDto,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("region") val region: String?,
    @SerializedName("population") val population: Int?
) {
    data class FlagsDto(
        @SerializedName("png") val png: String,
        @SerializedName("svg") val svg: String
    )
}
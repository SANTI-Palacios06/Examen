package com.example.examen.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryListDto(
    @SerializedName("name") val name: CountryNameDto
)
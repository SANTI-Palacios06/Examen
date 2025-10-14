package com.example.examen.data.mapper

import CountryDetailDto
import com.example.examen.domain.model.Country

fun CountryDetailDto.toDomain(): Country {
    return Country(
        name = name.common.replaceFirstChar { it.uppercase() },
        officialName = name.official,
        flagUrl = flags.png,
        capital = capital?.firstOrNull(),
        region = region,
        subregion = subregion,
        population = population,
        area = area,
        borders = borders
    )
}
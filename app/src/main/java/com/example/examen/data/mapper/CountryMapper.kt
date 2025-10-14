package com.app.countryapp.data.mapper

import CountryDetailDto
import com.app.countryapp.data.remote.dto.CountryListDto
import com.example.examen.domain.model.Country


fun CountryListDto.toDomain(): Country {
    return Country(
        name = name.common.replaceFirstChar { it.uppercase() },
        officialName = name.official,
        flagUrl = flags.png,
        capital = capital?.firstOrNull(),
        region = region,
        subregion = null,
        population = population,
        area = null,
        borders = null
    )
}

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
package com.example.examen.presentation.screens.home

import com.example.examen.domain.model.Country

data class CountryListUiState(
    val countryList: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
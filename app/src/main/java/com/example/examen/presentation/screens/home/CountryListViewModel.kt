package com.example.examen.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.countryapp.domain.usecase.GetCountryListUseCase
import com.example.examen.domain.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountryListUseCase: GetCountryListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountryListUiState())
    val uiState: StateFlow<CountryListUiState> = _uiState.asStateFlow()

    init {
        loadCountryList()
    }

    fun loadCountryList() {
        viewModelScope.launch {
            getCountryListUseCase().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = true,
                            error = null
                        )
                    }
                    is Result.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            countryList = result.data,
                            error = null
                        )
                    }
                    is Result.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = result.exception.message ?: "Unknown error"
                        )
                    }
                }
            }
        }
    }
}
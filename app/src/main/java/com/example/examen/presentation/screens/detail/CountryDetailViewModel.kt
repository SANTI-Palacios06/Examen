package com.example.examen.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.examen.domain.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.examen.domain.usecase.GetCountryByNameUseCase

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryByNameUseCase: GetCountryByNameUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountryDetailUiState())
    val uiState: StateFlow<CountryDetailUiState> = _uiState.asStateFlow()

    fun getCountry(name: String) {
        viewModelScope.launch {
            getCountryByNameUseCase(name).collect { result ->
                _uiState.update { state ->
                    when (result) {
                        is Result.Loading -> state.copy(
                            isLoading = true
                        )
                        is Result.Success -> state.copy(
                            country = result.data,
                            isLoading = false,
                            error = null
                        )
                        is Result.Error -> state.copy(
                            error = result.exception.message,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}
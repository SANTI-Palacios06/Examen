package com.example.examen.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.countryapp.domain.usecase.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.examen.domain.common.Result

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountryListUseCase: GetCountryListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountryListUiState())
    val uiState: StateFlow<CountryListUiState> = _uiState.asStateFlow()

    init {
        loadCountryList()
    }

    private fun loadCountryList() {
        viewModelScope.launch {
            getCountryListUseCase().collect { result ->
                _uiState.update { state ->
                    when (result) {
                        is Result.Loading -> state.copy(
                            isLoading = true
                        )
                        is Result.Success -> state.copy(
                            countryList = result.data,
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
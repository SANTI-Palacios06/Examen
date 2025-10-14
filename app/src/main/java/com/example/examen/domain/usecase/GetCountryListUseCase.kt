package com.app.countryapp.domain.usecase

import com.app.countryapp.domain.repository.CountryRepository
import com.example.examen.domain.model.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.examen.domain.common.Result
import javax.inject.Inject

class GetCountryListUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<Result<List<Country>>> = flow {
        try {
            emit(Result.Loading)
            val countryList = repository.getCountryList()
            emit(Result.Success(countryList))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
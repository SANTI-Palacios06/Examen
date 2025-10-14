package com.example.examen.domain.usecase

import com.app.countryapp.domain.repository.CountryRepository
import com.example.examen.domain.model.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.examen.domain.common.Result

class GetCountryByNameUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(name: String): Flow<Result<Country>> = flow {
        try {
            emit(Result.Loading)
            val country = repository.getCountryByName(name)
            emit(Result.Success(country))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
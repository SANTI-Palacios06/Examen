package com.example.examen.di

import CountryRepositoryImpl
import com.app.countryapp.data.remote.api.CountryApi
import com.app.countryapp.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryApi(retrofit: Retrofit): CountryApi {
        return retrofit.create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(
        api: CountryApi
    ): CountryRepository {
        return CountryRepositoryImpl(api)
    }
}
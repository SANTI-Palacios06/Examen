package com.example.examen.di

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
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("Http")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    //@Provides
    //@Singleton
    //fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    //@Provides
    //@Singleton
    //fun providePokemonRepository(api: PokemonApi): PokemonRepository = PokemonRepositoryImpl(api)
}

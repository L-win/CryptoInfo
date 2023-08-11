package com.elvina.cryptoinfo.di

import com.elvina.cryptoinfo.data.remote.API
import com.elvina.cryptoinfo.data.repository.CoinRepositoryImpl
import com.elvina.cryptoinfo.domain.repository.CoinRepository
import com.elvina.cryptoinfo.other.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): API{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: API): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}
package com.elvina.cryptoinfo.data.remote

import com.elvina.cryptoinfo.data.remote.dto.CoinDetailDto
import com.elvina.cryptoinfo.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String): CoinDetailDto
}
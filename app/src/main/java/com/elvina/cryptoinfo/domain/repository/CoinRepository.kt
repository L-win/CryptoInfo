package com.elvina.cryptoinfo.domain.repository

import com.elvina.cryptoinfo.data.remote.dto.CoinDetailDto
import com.elvina.cryptoinfo.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
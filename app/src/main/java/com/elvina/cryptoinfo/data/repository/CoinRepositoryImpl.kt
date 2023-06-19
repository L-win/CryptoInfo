package com.elvina.cryptoinfo.data.repository

import com.elvina.cryptoinfo.data.remote.CoinPaprikaAPI
import com.elvina.cryptoinfo.data.remote.dto.CoinDetailDto
import com.elvina.cryptoinfo.data.remote.dto.CoinDto
import com.elvina.cryptoinfo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}
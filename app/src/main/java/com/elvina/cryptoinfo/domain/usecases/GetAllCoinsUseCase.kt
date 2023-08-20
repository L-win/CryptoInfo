package com.elvina.cryptoinfo.domain.usecases

import com.elvina.cryptoinfo.data.remote.dto.toCoin
import com.elvina.cryptoinfo.domain.model.Coin
import com.elvina.cryptoinfo.domain.repository.CoinRepository
import com.elvina.cryptoinfo.other.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins.subList(0,15)))
        }catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check internet connection."))
        }
    }
}
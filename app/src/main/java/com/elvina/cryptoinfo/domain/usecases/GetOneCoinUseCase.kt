package com.elvina.cryptoinfo.domain.usecases

import com.elvina.cryptoinfo.data.remote.dto.toCoinDetail
import com.elvina.cryptoinfo.domain.model.CoinDetail
import com.elvina.cryptoinfo.domain.repository.CoinRepository
import com.elvina.cryptoinfo.other.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetOneCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check internet connection."))
        }
    }
}
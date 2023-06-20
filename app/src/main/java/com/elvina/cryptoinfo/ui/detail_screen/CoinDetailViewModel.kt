package com.elvina.cryptoinfo.ui.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvina.cryptoinfo.domain.use_cases.get_all_coins.GetAllCoinsUseCase
import com.elvina.cryptoinfo.domain.use_cases.get_one_coin.GetOneCoinUseCase
import com.elvina.cryptoinfo.other.Constants
import com.elvina.cryptoinfo.other.Resource
import com.elvina.cryptoinfo.ui.main_screen.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetOneCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init{
        savedStateHandle.get<String>(Constants.COIN_ID)?.let{
            coinId->getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error->{
                    _state.value = CoinDetailState(
                        error = result.message ?: "An uexpected error occured"
                    )
                }
                is Resource.Loading->{
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
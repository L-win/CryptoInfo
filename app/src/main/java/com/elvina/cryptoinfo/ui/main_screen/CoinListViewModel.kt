package com.elvina.cryptoinfo.ui.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvina.cryptoinfo.domain.use_cases.get_all_coins.GetAllCoinsUseCase
import com.elvina.cryptoinfo.other.Resource
import com.elvina.cryptoinfo.ui.main_screen.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetAllCoinsUseCase
): ViewModel(){
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init{
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = CoinListState(
                        error = result.message ?: "An uexpected error occured"
                    )
                }
                is Resource.Loading->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
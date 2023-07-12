package com.elvina.cryptoinfo.ui.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import com.elvina.cryptoinfo.domain.use_cases.get_one_coin.GetOneCoinUseCase
import com.elvina.cryptoinfo.other.Constants
import com.elvina.cryptoinfo.other.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getCoinUseCase: GetOneCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DetailScreenState())
    val state: State<DetailScreenState> = _state
    var coinSymbol: String = ""

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }

        savedStateHandle.get<String>(Constants.COIN_SYMBOL)?.let {
                symbol-> coinSymbol = symbol
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailScreenState(coin = result.data, coinSymbol = coinSymbol)
                }

                is Resource.Error -> {
                    _state.value = DetailScreenState(
                        error = result.message ?: "An uexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = DetailScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
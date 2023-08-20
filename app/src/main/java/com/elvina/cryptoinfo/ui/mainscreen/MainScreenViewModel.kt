package com.elvina.cryptoinfo.ui.mainscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvina.cryptoinfo.domain.usecases.GetAllCoinsUseCase
import com.elvina.cryptoinfo.other.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCoinsUseCase: GetAllCoinsUseCase
): ViewModel(){
    private val _state = mutableStateOf(MainScreenState())
    val state: State<MainScreenState> = _state

    init{
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = MainScreenState(coins = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = MainScreenState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading->{
                    _state.value = MainScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
package com.elvina.cryptoinfo.ui.main_screen

import com.elvina.cryptoinfo.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

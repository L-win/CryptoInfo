package com.elvina.cryptoinfo.ui.detail_screen

import com.elvina.cryptoinfo.domain.model.Coin
import com.elvina.cryptoinfo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

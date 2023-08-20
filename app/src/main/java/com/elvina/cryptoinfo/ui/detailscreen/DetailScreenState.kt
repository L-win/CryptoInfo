package com.elvina.cryptoinfo.ui.detailscreen

import com.elvina.cryptoinfo.domain.model.CoinDetail

data class DetailScreenState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
    val coinSymbol: String = ""
)

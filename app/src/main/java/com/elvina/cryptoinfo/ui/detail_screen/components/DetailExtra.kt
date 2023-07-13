package com.elvina.cryptoinfo.ui.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elvina.cryptoinfo.domain.model.CoinDetail

@Composable
fun DetailExtra(coin: CoinDetail) {

    /* TODO: started */
    /* TODO: rank */

    /* TODO: hash */
    /* TODO: proof */

    /* TODO: open source */
    /* TODO: organization */

    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(5.dp)
                )
                .padding(15.dp),
            text = "${coin.started_at?.substring(0, 4)}",
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(5.dp)
                )
                .padding(15.dp),
            text = "${coin.rank}"
        )
    }

    Spacer(modifier = Modifier.height(15.dp))
    Row {
        Text(text = "${coin.hash}")
        Text(text = "${coin.proof}")
    }

    Spacer(modifier = Modifier.height(15.dp))
    Row {
        Text(text = "${coin.open_source}")
        Text(text = "${coin.organization}")
    }

}
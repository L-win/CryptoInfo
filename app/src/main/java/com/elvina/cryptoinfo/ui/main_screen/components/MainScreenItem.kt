package com.elvina.cryptoinfo.ui.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.elvina.cryptoinfo.domain.model.Coin

@Composable
fun MainScreenItem(
    coin: Coin,
    onItemClick: (Coin)->Unit
){
    Card(
        modifier =  Modifier.fillMaxWidth().clickable {onItemClick(coin)}.padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
            text = "${coin.rank}. ${coin.name} ${coin.symbol}",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
            Text(
            text = if(coin.is_active) "active" else "inactive",
            color = if(coin.is_active) Color.Magenta else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodySmall,
//            modifier = Modifier.align(CenterVertically)
        )
        }
    }

}
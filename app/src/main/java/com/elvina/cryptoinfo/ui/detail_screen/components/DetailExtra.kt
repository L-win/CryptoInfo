package com.elvina.cryptoinfo.ui.detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elvina.cryptoinfo.domain.model.CoinDetail

@Composable
fun DetailExtra(coin: CoinDetail) {

    /* TODO: started */
    /* TODO: rank */

    /* TODO: hash */
    /* TODO: proof */

    /* TODO: open source */
    /* TODO: organization */


    /* Started at*/
    /* Rank */
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(
                text = "Started",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight(16)
            )

            Text(
                modifier = Modifier.padding(15.dp),
                text = "${coin.started_at?.substring(0, 4)}",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Column{
            Text(
                text = "Rank",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight(16)
            )
            Text(
                modifier = Modifier.padding(15.dp),
                text = "${coin.rank}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }

    /* Hash */
    /* Proof */
    Spacer(modifier = Modifier.height(15.dp))
    Row {
        Text(text = "${coin.hash}")
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "${coin.proof}")
    }

    /* Open source */
    /* Organization */
    Spacer(modifier = Modifier.height(15.dp))
    Row {
        Text(text = "${coin.open_source}")
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "${coin.organization}")
    }

}
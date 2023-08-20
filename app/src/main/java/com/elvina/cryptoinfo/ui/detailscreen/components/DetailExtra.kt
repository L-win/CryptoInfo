package com.elvina.cryptoinfo.ui.detailscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
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

    /* Started at, Rank, Open Source*/

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

        Column {
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
                textAlign = TextAlign.Center,
            )
        }

        Column {
            Text(
                text = "Open Source",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight(16)
            )

            Text(
                text = if (coin.open_source == true) "Yes" else "No",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp),
                textAlign = TextAlign.Center,
            )
        }

    }

    Divider()

    /* Hash, Proof, Organization*/

    Spacer(modifier = Modifier.height(15.dp))
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Hash Algorithm",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight(16)
        )
        Text(text = "${coin.hash}", modifier = Modifier.padding(5.dp))

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Proof Type",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight(16)
        )
        Text(text = "${coin.proof}", modifier = Modifier.padding(5.dp))

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Organization",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight(16)
        )
        Text(text = "${coin.organization}", modifier = Modifier.padding(5.dp))
    }

    Divider()

}
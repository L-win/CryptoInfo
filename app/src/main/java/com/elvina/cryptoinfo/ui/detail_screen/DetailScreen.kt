package com.elvina.cryptoinfo.ui.detail_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elvina.cryptoinfo.ui.detail_screen.components.TeamListItem

@Composable
fun DetailScreen(
	viewModel: DetailScreenViewModel = hiltViewModel()
){
	val state = viewModel.state.value
	Box(modifier = Modifier.fillMaxSize()){
		state.coin?.let {
			coin -> LazyColumn(
				modifier = Modifier.fillMaxSize(),
				contentPadding = PaddingValues(20.dp)
			){
				item{
					Row(
						modifier = Modifier.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceBetween
					){
						Text(
							text = "${coin.rank}  ${coin.symbol} - ${coin.name}",
							style = MaterialTheme.typography.bodyLarge,
							modifier = Modifier.weight(8f)
						)
					}
					Spacer(modifier = Modifier.height(15.dp))
					Text(
						text="Description",
						fontSize = 16.sp,
						fontWeight = FontWeight(12)
					)
					Spacer(modifier = Modifier.height(15.dp))
					Text(
						text = coin.description,
						style = MaterialTheme.typography.bodyMedium
					)
					Spacer(modifier = Modifier.height(15.dp))
					Text(
						text= "Creators",
						fontSize = 16.sp,
						fontWeight = FontWeight(12)
					)
					Spacer(modifier = Modifier.height(15.dp))
				}
				items(coin.team){
					teamMember ->
					TeamListItem(
						teamMember = teamMember,
						modifier = Modifier.fillMaxWidth().padding(10.dp)
					)
					Divider()
				}
			}
		}
		if (state.error.isNotBlank()){
			Text(
				text = state.error,
				color = Color.Red,
				textAlign = TextAlign.Center,
				modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).align(Alignment.Center)
			)
		}
		if(state.isLoading){
			CircularProgressIndicator(
				modifier = Modifier.align(Alignment.Center),
				color = MaterialTheme.colorScheme.secondary
			)
		}
	}
}
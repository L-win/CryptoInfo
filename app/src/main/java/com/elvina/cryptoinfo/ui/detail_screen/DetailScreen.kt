package com.elvina.cryptoinfo.ui.detail_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.elvina.cryptoinfo.ui.Screen
import com.elvina.cryptoinfo.ui.detail_screen.components.DetailExtra
import com.elvina.cryptoinfo.ui.detail_screen.components.TeamListItem

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailScreenViewModel = hiltViewModel()

) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = state.coinSymbol)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.MainScreen.route)
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "homeIcon",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            state.coin?.let { coin ->
                LazyColumn(
                    modifier = Modifier
                        .wrapContentHeight(),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    item {

                        /* Logo */
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = "${coin.logo}",
                                contentDescription = null,
                                modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.surface,
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(10.dp)
                            )
                        }

                        /* Title */
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${coin.name}, ${coin.symbol}",
                                modifier = Modifier.weight(16f),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }

                        /* Description */
                        Spacer(modifier = Modifier.height(15.dp))
//                        Text(
//                            text = "Description",
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight(12)
//                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            modifier = Modifier
                                .background(
                                    MaterialTheme.colorScheme.surface,
                                    RoundedCornerShape(5.dp)
                                )
                                .padding(15.dp),
                            text = coin.description,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        /* Extra information */
                        DetailExtra(coin = coin)

                        /* Creators list */
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Creators",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(12)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    items(coin.team) { teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        Divider()
                    }
                }

            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
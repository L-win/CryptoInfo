package com.elvina.cryptoinfo.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.elvina.cryptoinfo.ui.Screen
import com.elvina.cryptoinfo.ui.main_screen.components.MainScreenItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Top App Bar")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White,
                    ),
                )
            }, content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(Color(0xff8d6e63)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ){

                        items(state.coins){
                                coin -> MainScreenItem( coin = coin, onItemClick = {navController.navigate(Screen.DetailScreen.route + "/${coin.id}")} )
                        }
                    }
                    if(state.error.isNotBlank()){
                        Text(
                            text = state.error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
//                                .align(Alignment.Center)
                        )
                    }
                    if(state.isLoading){
                        CircularProgressIndicator()
                    }

                }
            })

    }

}
package com.elvina.cryptoinfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elvina.cryptoinfo.ui.detail_screen.DetailScreen
import com.elvina.cryptoinfo.ui.main_screen.MainScreen
import com.elvina.cryptoinfo.ui.theme.CryptoInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
					{
						val navController = rememberNavController()
						NavHost(
							navController = navController,
							startDestination = Screen.MainScreen.route
						){
							composable(
								route = Screen.MainScreen.route
							){
								MainScreen(navController)
							}
							composable(
								route = Screen.DetailScreen.route + "/{coinId}"
							){
								DetailScreen()
							}
						}

                }
            }
        }
    }
}
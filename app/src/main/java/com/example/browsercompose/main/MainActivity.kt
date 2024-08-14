package com.example.browsercompose.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.browsercompose.about.AboutScreen
import com.example.browsercompose.browser.BrowserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.Browser.route
            ) {
                composable(route = Screen.Browser.route) {
                    BrowserScreen(
                        onAboutClicked = {
                            navController.navigate(Screen.About.route)
                        }
                    )
                }
                composable(route = Screen.About.route) {
                    AboutScreen(
                        onCloseClicked = {
                            navController.navigateUp()
                        }
                    )
                }
            }
        }
    }

}
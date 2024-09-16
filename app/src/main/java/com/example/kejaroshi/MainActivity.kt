package com.example.yourapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kejaroshi.Auth.SplashScreen
import com.example.kejaroshi.Home.HomeScreen
import com.example.kejaroshi.settingpage.SettingPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash_screen") {
                composable("splash_screen") {
                    SplashScreen(navController)
                }
                composable("home_screen") {
                    HomeScreen(navController)
                }
                composable("setting_page") {
                    SettingPage()
                }
            }
        }
    }
}

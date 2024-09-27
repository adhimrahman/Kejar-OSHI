package com.example.kejaroshi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kejaroshi.splash.SplashScreen
import com.example.kejaroshi.auth.SignInActivity
import com.example.kejaroshi.auth.SignUpActivity
import com.example.kejaroshi.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash_screen") {
                composable("splash_screen") {
                    SplashScreen(navController)
                }
                composable("signin_page") {
                    SignInActivity(navController)
                }
                composable("signup_page") {
                    SignUpActivity(navController)
                }
                composable("home_page") {
                    HomeScreen()
                }
            }
        }
    }
}

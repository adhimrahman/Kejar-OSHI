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
import com.example.kejaroshi.home.SettingPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.Splash.route
            ) {
                composable(Screen.Splash.route) {
                    SplashScreen(navController)
                }
                composable(Screen.SignIn.route) {
                    SignInActivity(navController)
                }
                composable(Screen.SignUp.route) {
                    SignUpActivity(navController)
                }
                composable(Screen.Home.route) {
                    HomeScreen(navController)
                }
                composable(Screen.Settings.route) {
                    SettingPage(navController)
                }
            }
        }
    }
}

// Define the screens in your app
sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object SignIn : Screen("signin_page")
    object SignUp : Screen("signup_page")
    object Home : Screen("home_page")
    object Settings : Screen("setting_page")
}
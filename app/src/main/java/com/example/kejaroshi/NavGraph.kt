package com.example.kejaroshi

import android.provider.ContactsContract.Profile
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import features.landing.LandingPage
import com.example.kejaroshi.presentation.ui.bencana.BencanaPage
import com.example.kejaroshi.presentation.ui.limbah.LimbahPage
import features.auth.SignInPage
import features.auth.SignUpPage
import features.auth.UserViewModel
import features.profile.ProfilePage
import splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, userViewModel: UserViewModel) {

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") { SplashScreen(navController) }
        composable("landing") { LandingPage(navController) }
        composable("bencana") { BencanaPage(navController) }
        composable("signin") { SignInPage(navController, userViewModel = userViewModel) }
        composable("lingkungan") { LimbahPage(navController) }
        composable("signup") { SignUpPage(navController) }
        composable("profile") { ProfilePage(navController, userViewModel = userViewModel) }

    }
}
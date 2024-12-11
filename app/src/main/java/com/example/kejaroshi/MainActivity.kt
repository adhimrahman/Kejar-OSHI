package com.example.kejaroshi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import features.auth.UserViewModel
import com.example.kejaroshi.presentation.ui.theme.SigapTheme
import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        setContent {
            SigapTheme {
                val navController = rememberNavController()
                val userViewModel: UserViewModel = viewModel()

                Surface(color =  MaterialTheme.colorScheme.background) {
                    NavGraph(navController = navController, userViewModel = userViewModel)
                }
            }
        }
    }
}
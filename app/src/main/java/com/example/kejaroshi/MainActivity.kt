package com.example.kejaroshi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kejaroshi.ui.theme.SigapTheme
import features.auth.UserViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
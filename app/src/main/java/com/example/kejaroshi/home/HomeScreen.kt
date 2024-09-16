package com.example.kejaroshi.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Kejar OSHI - Home") })
        },
        content = {
            // Main content of the Home Screen
            Column {
                Text("Selamat datang di Kejar OSHI!")
                // Add other contents and actions here
            }
        }
    )
}
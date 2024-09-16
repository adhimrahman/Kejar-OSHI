package com.example.kejaroshi.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Button filled
            Button(
                onClick = { /* TODO: Tambahkan aksi */ },
                modifier = Modifier
                    .width(250.dp) // Atur lebar
                    .height(75.dp) // Atur tinggi
            ) {
                Text(text = "Filled Button")
            }

            // Button outline
            OutlinedButton(
                onClick = { navController.navigate("setting_page") },
                modifier = Modifier
                    .width(250.dp) // Atur lebar
                    .height(75.dp) // Atur tinggi
            ) {
                Text(text = "Outline Button")
            }
        }
    }
}

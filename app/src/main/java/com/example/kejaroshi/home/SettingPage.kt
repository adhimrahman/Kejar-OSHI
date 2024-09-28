package com.example.kejaroshi.home

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
fun SettingPage(navController: NavHostController) {
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
                onClick = { /*tambahkan aksi*/ },
                modifier = Modifier
                    .width(250.dp)
                    .height(75.dp)
            ) {
                Text(text = "Filled Button")
            }

            OutlinedButton(
                onClick = { navController.navigate("signin_page") },
                modifier = Modifier
                    .width(250.dp)
                    .height(75.dp)
            ) {
                Text(text = "Outlined Button")
            }
        }
    }
}
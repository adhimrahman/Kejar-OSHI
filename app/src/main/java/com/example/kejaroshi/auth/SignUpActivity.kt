package com.example.kejaroshi.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpActivity(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }

    val gradientColors = listOf(
        Color(0xFFFCE4EC),  // Light pink
        Color(0xFFF3E5F5),  // Light purple
        Color(0xFFE8EAF6)   // Light indigo
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = gradientColors)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sign Up",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Input Nama
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Input Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Input Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Checkbox untuk memilih role
            Text(
                text = "Login as",
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = role == "Pemerintah",
                    onCheckedChange = { role = if (it) "Pemerintah" else role }
                )
                Text("Pemerintah")

                Checkbox(
                    checked = role == "Vendor",
                    onCheckedChange = { role = if (it) "Vendor" else role }
                )
                Text("Vendor")

                Checkbox(
                    checked = role == "Sekolah",
                    onCheckedChange = { role = if (it) "Sekolah" else role }
                )
                Text("Sekolah")


                Checkbox(
                    checked = role == "Guest",
                    onCheckedChange = { role = if (it) "Guest" else role }
                )
                Text("Guest")

            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("home_page")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up")
            }
        }
    }
}

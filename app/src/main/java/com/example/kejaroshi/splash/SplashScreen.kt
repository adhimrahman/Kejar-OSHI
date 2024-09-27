package com.example.kejaroshi.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kejaroshi.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Menampilkan gambar logo di splash screen
        Image(
            painter = painterResource(id = R.drawable.spotitip_logo__4_), // Gambar dari drawable
            contentDescription = "Logo",
            modifier = Modifier.size(350.dp), // Ukuran gambar
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )

        // Navigasi ke home screen setelah delay
        LaunchedEffect(key1 = true) {
            delay(3000) // 3 detik
            navController.navigate("signin_page")
        }
    }
}
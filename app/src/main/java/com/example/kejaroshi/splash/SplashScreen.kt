package com.example.kejaroshi.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
    // Animasi Skala untuk Logo
    val scale = remember { Animatable(0.8f) }

    LaunchedEffect(Unit) {
        // Animasi pembesaran
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(durationMillis = 1000, easing = EaseInOutCubic)
        )
        delay(2000) // Total durasi splash screen
        navController.navigate("signin_page") {
            popUpTo("splash_screen") { inclusive = true } // Hapus splash screen dari back stack
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size((350 * scale.value).dp), // Menggunakan animasi skala
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
    }
}

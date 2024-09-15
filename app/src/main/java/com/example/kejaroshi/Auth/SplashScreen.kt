package com.example.kejaroshi.Auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.kejaroshi.Home.HomeScreen
import com.example.kejaroshi.R
import com.example.kejaroshi.ui.theme.KejarOSHITheme
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KejarOSHITheme {
                SplashScreenContent()
            }
        }

        // Navigate to HomeScreen after a delay
        lifecycleScope.launchWhenStarted {
            delay(3000) // 3 second delay
            startActivity(Intent(this@SplashScreen, HomeScreen::class.java))
            finish()
        }
    }
}

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.spotitip_logo__4_), // Use your app logo
            contentDescription = "App Logo",
            modifier = Modifier.size(350.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    KejarOSHITheme {
        SplashScreenContent()
    }
}
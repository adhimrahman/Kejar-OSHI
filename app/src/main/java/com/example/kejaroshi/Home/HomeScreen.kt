package com.example.kejaroshi.Home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kejaroshi.ui.theme.KejarOSHITheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KejarOSHITheme {
                HomeScreenContent()
            }
        }
    }
}

@Composable
fun HomeScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Button(onClick = { /* Handle filled button click */ }) {
            Text(text = "Filled Button")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = { /* Handle outline button click */ }) {
            Text(text = "Outline Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KejarOSHITheme {
        HomeScreenContent()
    }
}

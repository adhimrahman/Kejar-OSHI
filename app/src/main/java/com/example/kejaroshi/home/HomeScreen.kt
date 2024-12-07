package com.example.kejaroshi.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    // State untuk melacak tab yang aktif
    var selectedTab by remember { mutableStateOf("home") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Menampilkan konten berdasarkan tab aktif
            when (selectedTab) {
                "home" -> HomeContent(navController)
                "profile" -> ProfileContent(navController)
                "settings" -> SettingsContent(navController)
            }
        }
    }
}

@Composable
fun HomeContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome to the Home Screen!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun ProfileContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome to the Profile Screen!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun SettingsContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome to the Settings Screen!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedTab == "home",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("home")
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = selectedTab == "profile",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("profile")
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = selectedTab == "settings",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("settings")
            }
        )
    }
}

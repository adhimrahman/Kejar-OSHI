package com.example.kejaroshi.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kejaroshi.R

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
                "bencana" -> BencanaContent(navController)
                "lingkungan" -> LingkunganContent(navController)
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
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = "Bencana",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Box
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO: Implement search logic */ },
            placeholder = { Text("Search...") },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn for better performance
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(10) { // Replace 10 with your actual data size
                CampaignCard()
            }
        }
    }
}

@Composable
fun BencanaContent(navController: NavController) {

}

@Composable
fun LingkunganContent(navController: NavController) {

}

@Composable
fun CampaignCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Image Section
            Image(
                painter = painterResource(id = R.drawable.menu01), // Replace with actual image
                contentDescription = "Campaign Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Text Section
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Nama Campaign",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nama Komunitas",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo), // Replace with actual icon
                        contentDescription = "Calendar Icon",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Tanggal",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo), // Replace with actual icon
                        contentDescription = "Location Icon",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Lokasi",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
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
            icon = { Icon(Icons.Filled.Home, contentDescription = "Bencana") },
            label = { Text("Bencana") },
            selected = selectedTab == "bencana",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("bencana")
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Lingkungan") },
            label = { Text("Lingkungan") },
            selected = selectedTab == "lingkungan",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("linkungan")
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

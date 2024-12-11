package components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

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

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavBar (){
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf("home") }
    BottomNavigationBar(
        navController = navController,
        selectedTab = selectedTab,
        onTabSelected = { newTab -> selectedTab = newTab }
    )
}


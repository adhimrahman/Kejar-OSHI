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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kejaroshi.ui.icons.*

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
                navController.navigate("landing")
            }
        )

        NavigationBarItem(
            icon = { Icon(Warning, contentDescription = "Bencana") },
            label = { Text("Disaster") },
            selected = selectedTab == "bencana",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("bencana")
                navController.navigate("bencana")
            }
        )

        NavigationBarItem(
            icon = { Icon(Leaf, contentDescription = "Lingkungan") },
            label = { Text("Nature") },
            selected = selectedTab == "lingkungan",
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFE91E63),
                unselectedIconColor = Color.Gray,
            ),
            onClick = {
                onTabSelected("linkungan")
                navController.navigate("lingkungan")
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
                navController.navigate("profile")
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


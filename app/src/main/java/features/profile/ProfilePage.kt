package features.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun ProfilePage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Picture
        AsyncImage(
            model = "https://example.com/profile-pic.png", // Ganti dengan URL atau gambar default
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        )

        // User Info
        Text("Nama Lengkap", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Email@example.com", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        Button(
            onClick = { navController.navigate("landing") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilePage (){
    var navController = rememberNavController()
    ProfilePage(navController = navController)
}
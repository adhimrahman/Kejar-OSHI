package features.landing

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun LandingPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text("SIGAP BERSAMA", fontSize = 24.sp, color = Color.Green)
        Spacer(modifier = Modifier.height(16.dp))

        // Statistics Card
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = "https://example.com/image1.png",
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("123.456 Relawan", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = "https://example.com/image1.png",
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("123.456 Komunitas", fontSize = 18.sp)
                }
            }
        }

        // Navigation Buttons
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("bencana") }) {
            Text("Lihat Bencana")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("lingkungan") }) {
            Text("Lihat Lingkungan")
        }
    }
}
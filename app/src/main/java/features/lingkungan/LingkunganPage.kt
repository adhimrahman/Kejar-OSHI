package features.lingkungan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LingkunganPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lingkungan", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(10) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Judul Lingkungan $it", fontSize = 18.sp)
                        Text("Deskripsi Lingkungan...", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}
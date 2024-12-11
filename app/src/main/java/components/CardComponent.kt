package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.kejaroshi.R
import com.example.kejaroshi.ui.icons.Calendar_month
import com.example.kejaroshi.ui.theme.Offwhite

@Composable
fun CardComponent(
    navController: NavController = rememberNavController(),
    detailPath: String = "detail",
    id: String = "0",
    image: Int? = R.drawable.zakyella4ever,
    name: String = "Default Name",
    creator: String = "Unknown Creator",
    date: String = "01-01-2024",
    location: String = "Unknown Location",
    cardBackgroundColor: Color = Offwhite
) {
    // Click action to navigate to the detail page
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .clickable {
                navController.navigate("$detailPath/$id")
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor)
    ) {
        Column {
            // Image part (top section)
            val painter = rememberAsyncImagePainter(image ?: R.drawable.mirsakonyol)
            Image(
                painter = painter,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)  // Set height for the image
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = creator, fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Calendar_month,
                        contentDescription = "Date",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = date, fontSize = 14.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = location, fontSize = 14.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardComponent() {
    val navController = rememberNavController()
    CardComponent(
        navController = navController,
        detailPath = "details",
        id = "123",
        image = R.drawable.mirsakonyol,
        name = "Sample Title",
        creator = "John Doe",
        date = "2024-12-12",
        location = "di bawah panji fakultas Teknik!!"
    )
}

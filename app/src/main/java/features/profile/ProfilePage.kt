package features.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.kejaroshi.R
import com.example.kejaroshi.ui.theme.*
import components.BottomNavigationBar


@Composable
fun ProfilePage(navController: NavController) {
    var selectedTab by remember { mutableStateOf("profile") }
    val image : Int = R.drawable.mirsakonyol
    Scaffold (
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(hijautua)
                .height(70.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "dfdsfd",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(all = 19.dp)
                )
                Text("Sigap Bersama", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = Dp(8f)), color = Color.White)
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp))
        {
            // Profile Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val painter = rememberAsyncImagePainter(image)
                    Image(
                        painter = painter,
                        contentDescription = "Profile Picture",
                        modifier = Modifier.size(80.dp).clip(RoundedCornerShape(100)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Nama", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column { Text("Aktivitas yang telah diikuti") }
                        Text("10")
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column { Text("Lencana") }
                        Text("10")
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column { Text("Poin") }
                        Text("10")
                    }
                }
            }

            // Personal Data Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Data Pribadi", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Nama") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("No Handphone") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(value = "", onValueChange = {}, label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
//                        IconButton(onClick = { /* Handle visibility toggle */ }) {
//                            Icon(painterResource(id = R.drawable.ic_visibility), contentDescription = "Toggle Password Visibility")
//                        }
                        })
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /* Handle edit action */ },
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(hijautua)
                    ) {
                        Text("Edit")
                    }
                }
            }

            // Badges Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Lencana", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("No badges yet", color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilePage() {
    val navController = rememberNavController()
    ProfilePage(navController = navController, )
}

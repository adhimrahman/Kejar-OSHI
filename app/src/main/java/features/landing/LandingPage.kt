package features.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kejaroshi.R
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.kejaroshi.ui.theme.hijautua
import components.BottomNavigationBar

@Composable
fun LandingPage(navController: NavController) {
    var selectedTab by remember { mutableStateOf("home") }
    Scaffold(
        topBar = {  },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            // Header Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bege),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "SIGAP BERSAMA",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Statistics Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatisticItem(text = "Relawan 123.456", iconResId = R.drawable.logo)
                    StatisticItem(text = "Komunitas 123.456", iconResId = R.drawable.logo)
                    StatisticItem(text = "Event 123.456", iconResId = R.drawable.logo)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Description Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Dalam beberapa tahun terakhir, peningkatan jumlah bencana alam dan pencemaran lingkungan, telah menjadi tantangan utama di Indonesia. Meskipun berbagai organisasi dan masyarakat berusaha untuk berpartisipasi, masih ada keterbatasan dalam akses informasi dan koordinasi untuk relawan yang ingin terlibat. Sigap Bersama hadir untuk menghubungkan relawan dengan kegiatan tanggap bencana dan kampanye pembersihan lingkungan, menciptakan wadah yang efektif bagi masyarakat untuk berkontribusi.",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // SIGAP BENCANA Section
            CustomCard(
                title = "SIGAP BENCANA",
                description = "Lebih banyak relawan, lebih besar dampaknya. Ada beragam pilihan aktivitas yang dapat diikuti untuk membuat perubahan besar.",
                imageResId = R.drawable.bege,
                buttonText = "Lihat Aktivitas Lain"
            ) {
                navController.navigate("bencana")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SIGAP LINGKUNGAN Section
            CustomCard(
                title = "SIGAP LINGKUNGAN",
                description = "Bergabunglah untuk melestarikan lingkungan. Pilihan aktivitas yang menyenangkan untuk dampak yang nyata.",
                imageResId = R.drawable.bege,
                buttonText = "Lihat Aktivitas Lain"
            ) {
                navController.navigate("lingkungan")
            }

            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.weight(1f)) // Mendorong footer ke bawah
            Footer()
        }
    }
}

@Composable
fun StatisticItem(text: String, iconResId: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CustomCard(
    title: String,
    description: String,
    imageResId: Int,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F9FA) // Warna latar lebih lembut
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Bayangan
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Title
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        blurRadius = 4f
                    )
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Description
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button
            Button(
                onClick = onButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF365E32) // Warna Hijau
                )
            ) {
                Text(
                    text = buttonText,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Footer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2E7D32)) // Hijau
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Ganti dengan resource logo
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Main Text
        Text(
            text = "SIGAP BERSAMA ADALAH PLATFORM PARTISIPASI RELAWAN UNTUK TANGGAP BENCANA DAN KAMPANYE LINGKUNGAN.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contact Info
        Text(
            text = "Contact Info",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "08xxxxxxxxxx (Partnership)\n08xxxxxxxxxx (Organization & NGO)\nokftunhas@gmail.com",
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tagline
        Text(
            text = "UBAH NIAT BAIK JADI AKSI BAIK HARI INI.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Divider
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(1.dp)
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Copyright
        Text(
            text = "Copyright © 2024 SIGMA - All rights reserved.",
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingPage() {
    val navController = rememberNavController()
    LandingPage(navController)
}

package features.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import components.BottomNavigationBar
import components.CustomCard
import components.Footer
import components.StatisticItem

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
            Spacer(modifier = Modifier.weight(1f))
            Footer()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingPage() {
    val navController = rememberNavController()
    LandingPage(navController)
}
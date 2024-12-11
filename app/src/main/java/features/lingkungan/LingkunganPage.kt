package features.lingkungan


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import components.BottomNavigationBar
import components.CardComponent
import com.example.kejaroshi.R
import com.example.kejaroshi.ui.theme.*

@Composable
fun SearchBar(){
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        placeholder = { Text("Search by creator, name, or location...", fontSize = 12.sp) },
        textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            unfocusedContainerColor = Offwhite,
            focusedContainerColor = Offwhite
        )
    )
}

@Composable
fun LingkunganPage(navController: NavController) {
    var selectedTab by remember {mutableStateOf("lingkungan")}
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
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Center)
                {
                    Text(text = "Limbah", fontSize = 40.sp, fontWeight = FontWeight.Bold)
                }

            SearchBar()

            LazyColumn {
                items(10) {
                    CardComponent()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingPage (){
    val navController = rememberNavController()
    LingkunganPage(navController = navController)
}
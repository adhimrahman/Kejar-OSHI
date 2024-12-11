package com.example.kejaroshi.presentation.ui.limbah


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.example.kejaroshi.presentation.ui.theme.hijautua
import components.SearchBar

@Composable
fun LimbahPage(
    navController: NavController,
    limbahViewModel: LimbahViewModel = remember { LimbahViewModel() }  // Get ViewModel instance
) {
    // Observe the state from ViewModel
    val limbahList = limbahViewModel.limbahList

    // Fetch data on initial load
    LaunchedEffect(true) {
        limbahViewModel.fetchLimbahData()
    }


    var selectedTab by remember {mutableStateOf("limbah")}
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

            LazyColumn(
                modifier = Modifier.padding(innerPadding)
            ) {
                items(limbahList.size) { index ->
                    val limbahItem = limbahList[index]
                    CardComponent(
                        navController = navController,
                        detailPath = "detail",
                        id = limbahItem.name, // Assuming 'id' is a property of EnvironmentData
                        image = limbahItem.image,
                        name = limbahItem.name,
                        creator = limbahItem.creator,
                        date = limbahItem.date,
                        location = limbahItem.locate
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLimbahPage (){
    val navController = rememberNavController()
    LimbahPage(navController = navController)
}
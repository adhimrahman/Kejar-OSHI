package features.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kejaroshi.R
import components.AuthButton
import components.InputFieldCustom

@Composable
fun SignInPage(navController: NavController, userViewModel: UserViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Background with gradient
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A1A), // Dark color
                        Color(0xFF3A7D44) // Greenish gradient
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp).padding(bottom = 24.dp)
            )

            // Card for login form
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF292929))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    InputFieldCustom(value = name, onValueChange = { name = it }, label = "Name")

                    InputFieldCustom(value = email, onValueChange = { email = it }, label = "Email")

                    Spacer(modifier = Modifier.height(12.dp))

                    InputFieldCustom(value = password, onValueChange = { password = it }, label = "Password")

                    Spacer(modifier = Modifier.height(16.dp))

                    // Error Message
                    if (errorMessage.isNotEmpty()) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    // Sign In Button
                    AuthButton(text = "Sign In") {
                        if (email.isBlank() || password.isBlank()) {
                            errorMessage = "Email dan password harus diisi."
                        } else {
                            errorMessage = ""
                            userViewModel.name.value = name
                            userViewModel.email.value = email
                            userViewModel.password.value = password
                            navController.navigate("landing")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sign Up Link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically // Tambahkan ini
            ) {
                Text(
                    text = "Belum punya akun?",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(
                    onClick = { navController.navigate("signup") }
                ) {
                    Text(
                        text = "Daftar",
                        color = Color(0xFFFFFFFF),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
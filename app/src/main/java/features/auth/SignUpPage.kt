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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kejaroshi.R
import androidx.navigation.NavController
import components.AuthButton
import components.InputFieldCustom

@Composable
fun SignUpPage(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF1A1A1A), // Dark color
                    Color(0xFF3A7D44) // Greenish gradient
                )
            )
        ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1E1E1E) // Latar belakang abu-abu gelap untuk form
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo), // Ganti dengan logo Anda
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = "Daftar Akun Baru",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                InputFieldCustom( value = fullName, onValueChange = { fullName = it }, label = "Nama Lengkap")

                Spacer(modifier = Modifier.height(8.dp))

                InputFieldCustom( value = email, onValueChange = { email = it }, label = "Email" )

                Spacer(modifier = Modifier.height(8.dp))

                InputFieldCustom( value = password, onValueChange = { password = it }, label = "Password")

                Spacer(modifier = Modifier.height(8.dp))

                InputFieldCustom( value = confirmPassword, onValueChange = { confirmPassword = it }, label = "Konfirmasi Password")

                Spacer(modifier = Modifier.height(16.dp))

                // Daftar Button
                AuthButton(text = "Daftar") {
                    if (fullName.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        errorMessage = "Semua kolom harus diisi."
                    } else if (password != confirmPassword) {
                        errorMessage = "Password tidak sesuai."
                    } else {
                        errorMessage = ""
                        navController.navigate("signin")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Login Link
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sudah punya akun?",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(onClick = { navController.navigate("signin") }) {
                        Text(
                            text = "Masuk",
                            color = Color(0xFF3A7D44),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}
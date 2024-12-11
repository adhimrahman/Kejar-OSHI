package features.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
}
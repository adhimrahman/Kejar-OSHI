package com.example.kejaroshi.presentation.ui.limbah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kejaroshi.data.repository.EnvironmentRepository
import com.example.kejaroshi.domain.model.EnvironmentData
import kotlinx.coroutines.launch

class LimbahViewModel(
    private val repository: EnvironmentRepository = EnvironmentRepository()  // Pass repository to fetch data
) : ViewModel() {

    // The list of fetched Bencana data
    var limbahList: List<EnvironmentData> = emptyList()
        private set

    // Fetch data from Firestore (repository)
    fun fetchLimbahData() {
        viewModelScope.launch {
            limbahList = repository.fetchLimbahData()  // Update the list from the repository
        }
    }
}
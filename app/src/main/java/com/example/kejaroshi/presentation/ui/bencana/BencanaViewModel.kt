package com.example.kejaroshi.presentation.ui.bencana

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kejaroshi.data.repository.EnvironmentRepository
import com.example.kejaroshi.domain.model.EnvironmentData
import kotlinx.coroutines.launch

class BencanaViewModel(
    private val repository: EnvironmentRepository = EnvironmentRepository()  // Pass repository to fetch data
) : ViewModel() {

    // The list of fetched Bencana data
    var bencanaList: List<EnvironmentData> = emptyList()
        private set

    // Fetch data from Firestore (repository)
    fun fetchBencanaData() {
        viewModelScope.launch {
            bencanaList = repository.fetchBencanaData()  // Update the list from the repository
        }
    }
}

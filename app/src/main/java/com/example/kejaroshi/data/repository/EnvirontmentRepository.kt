package com.example.kejaroshi.data.repository

import com.example.kejaroshi.data.source.remote.EnvironmentDataSource
import com.example.kejaroshi.domain.model.EnvironmentData

class EnvironmentRepository(
    private val dataSource: EnvironmentDataSource = EnvironmentDataSource()  // Initialize data source for Firestore
) {

    // Fetch Bencana data from Firestore
    suspend fun fetchBencanaData(): List<EnvironmentData> {
        return dataSource.getBencanaData()  // Fetch the data from Firestore
    }
    suspend fun fetchLimbahData(): List<EnvironmentData> {
        return dataSource.getLimbahData()  // Fetch the data from Firestore
    }
}

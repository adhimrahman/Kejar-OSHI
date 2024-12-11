package com.example.kejaroshi.data.source.remote

import com.example.kejaroshi.domain.model.EnvironmentData
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class EnvironmentDataSource {

    private val db = FirebaseFirestore.getInstance()

    // Fetch data from the Firestore collection "bencana"
    suspend fun getBencanaData(): List<EnvironmentData> {
        val snapshot = db.collection("bencana").get().await()  // Get the Firestore collection data
        val dataList = mutableListOf<EnvironmentData>()

        for (document in snapshot.documents) {
            val creator = document.getString("creator") ?: ""
            val date = document.getString("date") ?: ""
            val image = document.getString("image") ?: ""
            val locate = document.getString("locate") ?: ""
            val name = document.getString("name") ?: ""

            val environmentData = EnvironmentData(creator, date, image, locate, name)
            dataList.add(environmentData)
        }

        return dataList
    }

    suspend fun getLimbahData(): List<EnvironmentData> {
        val snapshot = db.collection("limbah").get().await()  // Get the Firestore collection data
        val dataList = mutableListOf<EnvironmentData>()

        for (document in snapshot.documents) {
            val creator = document.getString("creator") ?: ""
            val date = document.getString("date") ?: ""
            val image = document.getString("image") ?: ""
            val locate = document.getString("locate") ?: ""
            val name = document.getString("name") ?: ""

            val environmentData = EnvironmentData(creator, date, image, locate, name)
            dataList.add(environmentData)
        }

        return dataList
    }
}

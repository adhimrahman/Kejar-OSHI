package com.example.kejaroshi.data.repository

import com.example.kejaroshi.data.FirebaseModule
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.core.UserData
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private val firestore: FirebaseFirestore = FirebaseModule.firestore
    private val firebaseAuth = FirebaseModule.firebaseAuth

    suspend fun getUserData(userId: String): Result<UserData> {
        return try {
            val document = firestore.collection("users").document(userId).get().await()
            if (document.exists()) {
                Result.success(document.toObject(UserData::class.java)!!)
            } else {
                Result.failure(Exception("User not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signInWithEmail(email: String, password: String): FirebaseUser? {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: Exception) {
            null
        }
    }
}
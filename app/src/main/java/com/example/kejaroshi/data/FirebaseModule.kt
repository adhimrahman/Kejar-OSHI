package com.example.kejaroshi.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

object FirebaseModule {

    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
}

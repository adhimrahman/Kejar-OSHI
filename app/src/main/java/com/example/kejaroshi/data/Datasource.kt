package com.example.kejaroshi.data

import com.example.kejaroshi.R
import com.example.kejaroshi.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.menu01),
            Affirmation(R.string.affirmation2, R.drawable.menu02),
            Affirmation(R.string.affirmation3, R.drawable.menu03),
            Affirmation(R.string.affirmation4, R.drawable.menu04),
            Affirmation(R.string.affirmation5, R.drawable.menu05),
            Affirmation(R.string.affirmation6, R.drawable.menu06),
            Affirmation(R.string.affirmation7, R.drawable.menu07),
            Affirmation(R.string.affirmation8, R.drawable.menu08),
            Affirmation(R.string.affirmation9, R.drawable.menu09),
            Affirmation(R.string.affirmation10, R.drawable.menu10))
    }
}
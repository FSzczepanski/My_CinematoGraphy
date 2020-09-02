package com.example.mycinematography.data

data class Movie(val name: String, val note: String, val director: String, val grade: String) {
    override fun toString(): String {
        return "$name -$director -$note -$grade"
    }
}
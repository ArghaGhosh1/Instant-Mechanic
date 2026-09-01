package com.example.instantmechanic.Presentation.HomeScreen

data class Mechanic(
    val id: Int,
    val garageName: String,
    val imageUrl: String,
    val rating: Double,
    val distance: Double,
    val location: String,
    val address: String,
    val services: List<String>,
    val isOpen: Boolean,
    val workingHours: String,
    val phone: String
)
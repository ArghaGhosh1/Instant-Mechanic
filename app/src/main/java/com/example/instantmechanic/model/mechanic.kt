package com.example.instantmechanic.model


data class Mechanic(
    val id: String,
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

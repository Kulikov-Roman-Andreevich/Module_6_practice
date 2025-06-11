package com.roman_kulikov.domain.entities

interface Bouquet {
    val id: Int
    val name: String
    val price: Double
    val designId: Int?
}
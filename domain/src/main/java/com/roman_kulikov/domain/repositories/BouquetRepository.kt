package com.roman_kulikov.domain.repositories

import com.roman_kulikov.domain.entities.Bouquet

interface BouquetRepository {
    suspend fun fetchBouquets()
    suspend fun getBouquets(): List<Bouquet>
}
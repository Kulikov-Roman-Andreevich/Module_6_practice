package com.roman_kulikov.data.api

import com.roman_kulikov.data.api.models.BouquetResponse
import retrofit2.http.GET

interface BouquetRetrofit {
    @GET("/bouquets.json")
    suspend fun getBouquetsData(): BouquetResponse


}
package com.roman_kulikov.data.api.models

import com.squareup.moshi.Json

data class BouquetResponse(
    @Json(name = "flowers")
    val flowersList: List<FlowerApi>,

    @Json(name = "bouquets")
    val bouquetsList: List<BouquetApi>,

    @Json(name = "bouquets_filling")
    val bouquetsFillingList: List<BouquetFillingApi>
)

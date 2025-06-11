package com.roman_kulikov.data.api.models

import com.roman_kulikov.domain.entities.BouquetFilling
import com.squareup.moshi.Json

data class BouquetFillingApi(
    @Json(name = "bouquet_id")
    override val bouquetId: Int,

    @Json(name = "flower_id")
    override val flowerId: Int,

    @Json(name = "flower_count")
    override val flowerCount: Int

) : BouquetFilling

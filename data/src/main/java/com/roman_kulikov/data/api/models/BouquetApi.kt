package com.roman_kulikov.data.api.models

import com.roman_kulikov.domain.entities.Bouquet
import com.squareup.moshi.Json

data class BouquetApi(
    @Json(name = "id")
    override val id: Int,

    @Json(name = "name")
    override val name: String,

    @Json(name = "price")
    override val price: Double

) : Bouquet

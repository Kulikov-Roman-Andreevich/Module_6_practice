package com.roman_kulikov.data.api.models

import com.roman_kulikov.domain.entities.Flower
import com.squareup.moshi.Json

data class FlowerApi(
    @Json(name = "id")
    override val id: Int,

    @Json(name = "name")
    override val name: String,

    @Json(name = "provide_country")
    override val provideCountry: String? = null

) : Flower

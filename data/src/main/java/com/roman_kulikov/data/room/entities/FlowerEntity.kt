package com.roman_kulikov.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.roman_kulikov.domain.entities.Flower

@Entity(tableName = "flower_table")
data class FlowerEntity(
    @PrimaryKey
    override val id: Int,

    override val name: String

) : Flower
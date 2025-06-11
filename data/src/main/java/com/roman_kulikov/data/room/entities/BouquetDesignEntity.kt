package com.roman_kulikov.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.roman_kulikov.data.room.dao.BouquetDesign

@Entity(tableName = "bouquet_design_table")
data class BouquetDesignEntity(
    @PrimaryKey
    override val id: Int,

    override val name: String

) : BouquetDesign
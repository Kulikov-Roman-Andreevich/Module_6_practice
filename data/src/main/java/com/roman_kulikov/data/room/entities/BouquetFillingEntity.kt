package com.roman_kulikov.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.roman_kulikov.domain.entities.BouquetFilling

@Entity(
    tableName = "bouquet_filling_table",
    primaryKeys = ["bouquet_id", "flower_id"],
    foreignKeys = [
        ForeignKey(
            entity = FlowerEntity::class,
            parentColumns = ["id"],
            childColumns = ["flower_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BouquetEntity::class,
            parentColumns = ["id"],
            childColumns = ["bouquet_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BouquetFillingEntity(
    @ColumnInfo(name = "bouquet_id")
    override val bouquetId: Int,

    @ColumnInfo(name = "flower_id")
    override val flowerId: Int,

    @ColumnInfo(name = "flower_number")
    override val flowerCount: Int

) : BouquetFilling

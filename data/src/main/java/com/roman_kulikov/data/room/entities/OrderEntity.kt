package com.roman_kulikov.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.roman_kulikov.domain.entities.Order

@Entity(
    tableName = "order_table",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
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

data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Int = 0,

    @ColumnInfo(name = "user_id")
    override val userId: Int,

    @ColumnInfo(name = "bouquet_id")
    override val bouquetId: Int

) : Order
package com.roman_kulikov.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.roman_kulikov.domain.entities.Bouquet

@Entity(tableName = "bouquet_table")
data class BouquetEntity(
    @PrimaryKey
    override val id: Int = 0,

    override val name: String,

    override val price: Double

) : Bouquet {
    override fun equals(other: Any?): Boolean {
        return (other is BouquetEntity) && other.name == name && other.price == price
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }
}

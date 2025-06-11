package com.roman_kulikov.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.roman_kulikov.data.room.entities.FlowerEntity

@Dao
interface FlowerDao {

    @Insert(entity = FlowerEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(flowerList: List<FlowerEntity>)


}
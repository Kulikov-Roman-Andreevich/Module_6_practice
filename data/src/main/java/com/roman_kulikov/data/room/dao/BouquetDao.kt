package com.roman_kulikov.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roman_kulikov.data.room.entities.BouquetEntity
import com.roman_kulikov.data.room.entities.BouquetFillingEntity

@Dao
interface BouquetDao {

    @Insert(entity = BouquetEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBouquets(bouquetList: List<BouquetEntity>)

    @Insert(entity = BouquetFillingEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFilling(bouquetFillingList: List<BouquetFillingEntity>)

    @Delete(entity = BouquetEntity::class)
    suspend fun deleteBouquet(bouquet: BouquetEntity)

    @Query("DELETE FROM bouquet_table")
    suspend fun deleteAllBouquets()

    @Query("DELETE FROM bouquet_filling_table")
    suspend fun deleteAllBouquetsFilling()

    @Query("SELECT * FROM bouquet_table")
    suspend fun getBouquets(): List<BouquetEntity>

    @Query("SELECT * FROM bouquet_filling_table WHERE bouquet_id = :bouquetId")
    suspend fun getBouquetFilling(bouquetId: Int): List<BouquetFillingEntity>
}
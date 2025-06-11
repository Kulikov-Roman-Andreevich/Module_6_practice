package com.roman_kulikov.data.room

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Transaction
import com.roman_kulikov.data.room.dao.BouquetDao
import com.roman_kulikov.data.room.dao.FlowerDao
import com.roman_kulikov.data.room.dao.OrderDao
import com.roman_kulikov.data.room.dao.UserDao
import com.roman_kulikov.data.room.entities.BouquetEntity
import com.roman_kulikov.data.room.entities.BouquetFillingEntity
import com.roman_kulikov.data.room.entities.FlowerEntity
import com.roman_kulikov.data.room.entities.UserEntity
import com.roman_kulikov.data.room.entities.OrderEntity

@Database(
    entities = [
        UserEntity::class,
        OrderEntity::class,
        FlowerEntity::class,
        BouquetEntity::class,
        BouquetFillingEntity::class
    ],
    exportSchema = true,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        lateinit var db: AppDatabase

        fun initDb(context: Context) {
            db = Room.databaseBuilder(context, AppDatabase::class.java, "flower_db").build()
        }
    }

    abstract fun userDao(): UserDao
    abstract fun bouquetDao(): BouquetDao
    abstract fun flowerDao(): FlowerDao
    abstract fun orderDao(): OrderDao

    @Transaction
    suspend fun fetchBouquets(bouquetList: List<BouquetEntity>, bouquetFillingList: List<BouquetFillingEntity>) {
        val oldBouquets = bouquetDao().getBouquets()
        oldBouquets.subtract(bouquetList.toSet()).forEach {
            bouquetDao().deleteBouquet(it)
        }
        bouquetDao().insertAllBouquets(bouquetList)
        bouquetDao().insertAllFilling(bouquetFillingList)
    }

}
package com.roman_kulikov.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Transaction
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.roman_kulikov.data.room.dao.BouquetDao
import com.roman_kulikov.data.room.dao.FlowerDao
import com.roman_kulikov.data.room.dao.OrderDao
import com.roman_kulikov.data.room.dao.UserDao
import com.roman_kulikov.data.room.entities.BouquetDesignEntity
import com.roman_kulikov.data.room.entities.BouquetEntity
import com.roman_kulikov.data.room.entities.BouquetFillingEntity
import com.roman_kulikov.data.room.entities.FlowerEntity
import com.roman_kulikov.data.room.entities.OrderEntity
import com.roman_kulikov.data.room.entities.UserEntity

@Database(
    entities = [
        UserEntity::class,
        OrderEntity::class,
        FlowerEntity::class,
        BouquetEntity::class,
        BouquetFillingEntity::class,
        BouquetDesignEntity::class
    ],
    exportSchema = true,
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        lateinit var db: AppDatabase

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Create bouquet_design_table
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS bouquet_design_table (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
                        `name` TEXT NOT NULL
                    )
                """.trimIndent()
                )
                // Add design foreign key to bouquet_table
                db.execSQL("""
                    CREATE TABLE bouquet_table_temp (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
                        `name` TEXT NOT NULL, 
                        price REAL NOT NULL, 
                        design_id INTEGER NULL,
                        FOREIGN KEY(design_id) REFERENCES bouquet_design_table(id) ON DELETE CASCADE
                    )
                """.trimIndent()
                )

                db.execSQL("""
                    INSERT INTO bouquet_table_temp(id, `name`, price)
                    SELECT id, `name`, price FROM bouquet_table
                """.trimIndent())

                db.execSQL("DROP TABLE bouquet_table")
                db.execSQL("ALTER TABLE bouquet_table_temp RENAME TO bouquet_table")

                // Add provide_country to flower_table
                db.execSQL("ALTER TABLE flower_table ADD provide_country TEXT NULL")
            }

        }

        fun initDb(context: Context) {
            db = Room.databaseBuilder(context, AppDatabase::class.java, "flower_db").addMigrations(MIGRATION_1_2).build()
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
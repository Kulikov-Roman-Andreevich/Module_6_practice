package com.roman_kulikov.data.repositories

import com.roman_kulikov.data.api.BouquetsClient
import com.roman_kulikov.data.api.models.BouquetApi
import com.roman_kulikov.data.api.models.BouquetFillingApi
import com.roman_kulikov.data.api.models.FlowerApi
import com.roman_kulikov.data.room.AppDatabase
import com.roman_kulikov.data.room.entities.BouquetEntity
import com.roman_kulikov.data.room.entities.BouquetFillingEntity
import com.roman_kulikov.data.room.entities.FlowerEntity
import com.roman_kulikov.domain.entities.Bouquet
import com.roman_kulikov.domain.repositories.BouquetRepository

class BouquetsRepositoryImpl : BouquetRepository {
    private val bouquetDao = AppDatabase.db.bouquetDao()
    private val flowerDao = AppDatabase.db.flowerDao()

    private val api = BouquetsClient.apiService

    override suspend fun fetchBouquets() {
        val bouquetData = api.getBouquetsData()

        flowerDao.insertAll(bouquetData.flowersList.mapFlowerToEntities())
        AppDatabase.db.fetchBouquets(
            bouquetData.bouquetsList.mapBouquetToEntities(),
            bouquetData.bouquetsFillingList.mapBouquetFillingToEntities()
        )
    }

    override suspend fun getBouquets(): List<Bouquet> = bouquetDao.getBouquets()

    private fun List<FlowerApi>.mapFlowerToEntities(): List<FlowerEntity> =
        this.map { FlowerEntity(id = it.id, name = it.name) }

    private fun List<BouquetApi>.mapBouquetToEntities(): List<BouquetEntity> =
        this.map { BouquetEntity(id = it.id, name = it.name, price = it.price) }

    private fun List<BouquetFillingApi>.mapBouquetFillingToEntities(): List<BouquetFillingEntity> =
        this.map { BouquetFillingEntity(bouquetId = it.bouquetId, flowerId = it.flowerId, flowerCount = it.flowerCount) }


}
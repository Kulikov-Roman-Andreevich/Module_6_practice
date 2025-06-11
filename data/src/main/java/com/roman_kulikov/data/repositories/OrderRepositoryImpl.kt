package com.roman_kulikov.data.repositories

import com.roman_kulikov.data.room.AppDatabase
import com.roman_kulikov.data.room.entities.OrderEntity
import com.roman_kulikov.domain.repositories.OrderRepository

class OrderRepositoryImpl : OrderRepository {
    private val orderDao = AppDatabase.db.orderDao()

    override suspend fun makeOrder(userId: Int) {
        orderDao.deleteUserOrders(userId)
    }

    override suspend fun deleteOrderItem(orderId: Int) {
        orderDao.deleteOrderItem(orderId)
    }

    override suspend fun addOrderItem(userId: Int, bouquetId: Int) {
        orderDao.insert(OrderEntity(userId = userId, bouquetId = bouquetId))
    }
}
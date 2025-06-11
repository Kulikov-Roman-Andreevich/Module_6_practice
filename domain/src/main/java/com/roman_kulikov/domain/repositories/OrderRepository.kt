package com.roman_kulikov.domain.repositories

interface OrderRepository {
    suspend fun makeOrder(userId: Int)
    suspend fun deleteOrderItem(orderId: Int)
    suspend fun addOrderItem(userId: Int, bouquetId: Int)
}
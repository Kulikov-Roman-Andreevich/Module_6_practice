package com.roman_kulikov.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roman_kulikov.data.room.entities.OrderEntity

@Dao
interface OrderDao {

    @Insert(entity = OrderEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: OrderEntity)

    @Insert(entity = OrderEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orderList: List<OrderEntity>)

    @Query("SELECT * FROM order_table WHERE user_id = :userId")
    suspend fun getOrders(userId: Int): List<OrderEntity>

    @Query("DELETE FROM order_table WHERE user_id = :userId")
    suspend fun deleteUserOrders(userId: Int)

    @Query("DELETE FROM order_table WHERE id = :orderId")
    suspend fun deleteOrderItem(orderId: Int)
}
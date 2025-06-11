package com.roman_kulikov.module_6_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.roman_kulikov.data.repositories.BouquetsRepositoryImpl
import com.roman_kulikov.data.repositories.OrderRepositoryImpl
import com.roman_kulikov.data.repositories.UserRepositoryImpl
import com.roman_kulikov.data.room.entities.UserEntity
import com.roman_kulikov.domain.repositories.BouquetRepository
import com.roman_kulikov.domain.repositories.OrderRepository
import com.roman_kulikov.domain.repositories.UserRepository
import com.roman_kulikov.module_6_practice.car.Car
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val bouquetRepository: BouquetRepository = BouquetsRepositoryImpl()
    private val orderRepository: OrderRepository = OrderRepositoryImpl()
    private val userRepository: UserRepository = UserRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        launch {
            userRepository.addUser(UserEntity(email = "gg@g.ggg"))
            bouquetRepository.fetchBouquets()
            //orderRepository.addOrderItem(1, 1)
            Car.Builder().build()
        }
    }
}
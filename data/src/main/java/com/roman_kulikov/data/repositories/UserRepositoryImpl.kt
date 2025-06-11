package com.roman_kulikov.data.repositories

import com.roman_kulikov.data.room.AppDatabase
import com.roman_kulikov.data.room.entities.UserEntity
import com.roman_kulikov.domain.entities.User
import com.roman_kulikov.domain.repositories.UserRepository

class UserRepositoryImpl : UserRepository {
    private val userDao = AppDatabase.db.userDao()

    override suspend fun addUser(user: User) {
        if (user is UserEntity) {
                userDao.insert(user)
        }
    }


}
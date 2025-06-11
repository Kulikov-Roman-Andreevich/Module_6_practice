package com.roman_kulikov.domain.repositories

import com.roman_kulikov.domain.entities.User

interface UserRepository {
    suspend fun addUser(user: User)
}
package com.roman_kulikov.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.roman_kulikov.domain.entities.User

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Int = 0,

    override val email: String

) : User

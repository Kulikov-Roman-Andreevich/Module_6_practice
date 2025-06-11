package com.roman_kulikov.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.roman_kulikov.data.room.entities.UserEntity

@Dao
interface UserDao {

    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: UserEntity)


}
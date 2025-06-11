package com.roman_kulikov.module_6_practice

import android.app.Application
import com.roman_kulikov.data.room.AppDatabase

class FlowerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.initDb(applicationContext)
    }
}
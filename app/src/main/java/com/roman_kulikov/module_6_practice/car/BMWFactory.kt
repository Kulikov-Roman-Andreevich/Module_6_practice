package com.roman_kulikov.module_6_practice.car

import android.graphics.Color

class BMWFactory : CarFactory {
    override fun createEconomyCar(): Car {
        return Car.Builder()
            .addBrand("BMW")
            .addColor(Color.valueOf(Color.BLACK))
            .addWeals(4)
            .build()
    }

    override fun createLuxuryCar(): Car {
        return Car.Builder()
            .addBrand("BMW")
            .addColor(Color.valueOf(Color.GRAY))
            .addWeals(4)
            .build()
    }
}
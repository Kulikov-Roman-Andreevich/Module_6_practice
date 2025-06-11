package com.roman_kulikov.module_6_practice.car

import android.graphics.Color

class ToyotaFactory : CarFactory {
    override fun createEconomyCar(): Car {
        return Car.Builder()
            .addBrand("Toyota")
            .addColor(Color.valueOf(Color.RED))
            .addWeals(4)
            .build()
    }

    override fun createLuxuryCar(): Car {
        return Car.Builder()
            .addBrand("Toyota")
            .addColor(Color.valueOf(Color.WHITE))
            .addWeals(3)
            .build()
    }
}
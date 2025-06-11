package com.roman_kulikov.module_6_practice.car

interface CarFactory {
    fun createEconomyCar(): Car
    fun createLuxuryCar(): Car
}
package com.roman_kulikov.module_6_practice.car

import android.graphics.Color

open class Car protected constructor(weals: Int?, color: Color?, brand: String?) {

    class Builder {
        private var weals: Int? = null
        private var color: Color? = null
        private var brand: String? = null

        fun addWeals(weals: Int) = apply { this.weals = weals }
        fun addColor(color: Color) = apply { this.color = color }
        fun addBrand(type: String) = apply { this.brand = type }

        fun build() = Car(this.weals, this.color, this.brand)
    }


}
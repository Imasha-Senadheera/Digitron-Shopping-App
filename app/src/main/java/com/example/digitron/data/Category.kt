package com.example.digitron.data

sealed class Category(val category: String) {

    object IPhone: Category("iPhone")
    object Mac: Category("Mac")
    object AppleWatch: Category("Apple Watch")
    object IPads: Category("iPads")
    object Accessory: Category("Accessory")
}
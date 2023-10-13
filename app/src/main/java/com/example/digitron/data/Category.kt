package com.example.digitron.data

sealed class Category(val category: String) {

    object IPhone: Category("iPhone")
    object Mac: Category("Mac")
    object IPads: Category("iPads")
    object AppleWatch: Category("Apple Watch")
    object Accessories: Category("Accessory")
}
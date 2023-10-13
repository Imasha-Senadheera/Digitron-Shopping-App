package com.example.digitron.data

sealed class Category(val category: String) {

    object Chair: Category("iPhone")
    object Cupboard: Category("Mac")
    object Table: Category("Apple Watch")
    object Accessory: Category("iPads")
    object Furniture: Category("Accessory")
}
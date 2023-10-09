package com.example.digitron.util

import androidx.fragment.app.Fragment
import com.example.digitron.R
import com.example.digitron.activities.ShoppingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Fragment.hideBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.example.digitron.R.id.bottomNavigation
        )
    bottomNavigationView.visibility = android.view.View.GONE
}

fun Fragment.showBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.example.digitron.R.id.bottomNavigation
        )
    bottomNavigationView.visibility = android.view.View.VISIBLE
}
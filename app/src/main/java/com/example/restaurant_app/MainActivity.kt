package com.example.restaurant_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.restaurant_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //adat elérés
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //mozogni a fragmentek kozott
        val navController = findNavController(R.id.myNavHostFragment)
        // a menühöz, e miatt kell a data binding
        val bottomNav = binding.bottomNavigationView
        //bottom nav inicializálás
        bottomNav?.setupWithNavController(navController)
    }
}
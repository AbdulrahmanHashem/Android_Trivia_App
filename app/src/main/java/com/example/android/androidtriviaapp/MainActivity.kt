package com.example.android.androidtriviaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.androidtriviaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var NavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavController = this.findNavController(R.id.myNavHostFragment)
        // can we get a referance to the navcontroller with databinding of our view

        NavigationUI.setupActionBarWithNavController(this, NavController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, NavController) // what does this do ?

        NavController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination , args: Bundle? ->
            if (nd.id == nc.graph.startDestinationId) {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(NavController, binding.drawerLayout)
    }
}
package com.example.androidlab3.task5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task5ActivityMainBinding
import com.example.androidlab3.task2.ActivityAbout

class ActivityMain : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Task5ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
        val navController = navHostFragment.navController

        // configuration that knows that we're using
        // a drawer and the appbar should have a button
        // for opening it
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawer1)
        // synchronizes the navController with the appbar
        setupActionBarWithNavController(navController, appBarConfiguration)
        // synchronizes the navController with the drawer menu
        binding.navView1.setupWithNavController(navController)

        binding.navView1.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.open_about -> {
                    startActivity(Intent(this, ActivityAbout::class.java))
                    binding.drawer1.closeDrawer(GravityCompat.START, true)
                    true
                }
                else -> {
                    // navigates to the destination described
                    // by the id of this menu item via the
                    // menu asset
                    val that = it.onNavDestinationSelected(navController)
                    binding.drawer1.closeDrawer(GravityCompat.START, true)
                    that
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // appbar upper left button won't work
        // without this code
        val navController = findNavController(R.id.navigation_host)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
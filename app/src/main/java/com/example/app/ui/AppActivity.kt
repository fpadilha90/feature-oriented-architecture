package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app.R
import kotlinx.android.synthetic.main.activity_main.*

class AppActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(getNavHostFragment().navController.graph)

        setupActionBarWithNavController(getNavHostFragment().navController, appBarConfiguration)

        bottom_nav_view.setupWithNavController(getNavHostFragment().navController)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)

    private fun getNavHostFragment() = (my_nav_host_fragment as NavHostFragment)

}
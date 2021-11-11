package me.artyom.androidcourse.lab03.task2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class Activity1 : BaseActivity(R.layout.fragment_1) {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Burger menu
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<Button>(R.id.bnToSecond).setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration)
}
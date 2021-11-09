package me.artyom.androidcourse.lab03.task2

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import androidx.navigation.ui.AppBarConfiguration
import me.artyom.androidcourse.lab03.task2.databinding.ActivityMainBinding

open class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private lateinit var root: DrawerLayout
    lateinit var toFirst: Button
    lateinit var toSecond: Button
    lateinit var toThird: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // NavigationDrawer
        binding = ActivityMainBinding.inflate(layoutInflater)
        root = binding.root
        setContentView(binding.drawerLayout)

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        //Activity visible buttons
        toFirst = findViewById(R.id.bnToFirst)
        toSecond = findViewById(R.id.bnToSecond)
        toThird = findViewById(R.id.bnToThird)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    fun Button.disappear() {
        //(this.parent as ViewGroup).removeView(this)
        this.visibility = View.GONE
    }
}
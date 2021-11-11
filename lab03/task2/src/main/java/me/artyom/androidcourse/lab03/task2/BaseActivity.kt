package me.artyom.androidcourse.lab03.task2

import android.os.Bundle
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import me.artyom.androidcourse.lab03.task2.databinding.ActivityMainBinding

open class BaseActivity(private val layoutResource: Int) : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // NavigationDrawer
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)

        val stub = findViewById<ViewStub>(R.id.viewStub)
        stub.layoutResource = layoutResource
        stub.inflate()
    }
}
package me.artyom.androidcourse.lab03.task4

import android.content.Intent
import android.os.Bundle

class Activity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toSecond.disappear()

        toFirst.setOnClickListener { finish() }

        toThird.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }
    }
}
package me.artyom.androidcourse.lab03.task2

import android.content.Intent
import android.os.Bundle

class Activity1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toFirst.disappear()
        toThird.disappear()

        toSecond.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }
}
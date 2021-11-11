package me.artyom.androidcourse.lab03.task4

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity2 : BaseActivity(R.layout.fragment_2)  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.bnToFirst).setOnClickListener { finish() }

        findViewById<Button>(R.id.bnToThird).setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }
    }
}
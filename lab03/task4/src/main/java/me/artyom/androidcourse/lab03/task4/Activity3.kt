package me.artyom.androidcourse.lab03.task4

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity3 : BaseActivity(R.layout.fragment_3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.bnToFirst).setOnClickListener { finish() }

        findViewById<Button>(R.id.bnToSecond).setOnClickListener {
            startActivity(
                Intent(this, Activity2::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
            finish()
        }
    }
}
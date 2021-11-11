package me.artyom.androidcourse.lab03.task3

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity3 : BaseActivity(R.layout.fragment_3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            startActivity(
                Intent(this, Activity1::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
            //finish()
        }

        findViewById<Button>(R.id.bnToSecond).setOnClickListener { finish() }
    }
}

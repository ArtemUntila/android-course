package me.artyom.androidcourse.lab03.task3

import android.content.Intent
import android.os.Bundle

class Activity3 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toThird.disappear()

        toFirst.setOnClickListener {
            startActivity(
                Intent(this, Activity1::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
            finish()
        }

        toSecond.setOnClickListener {
            finish()
        }
    }
}

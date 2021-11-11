package me.artyom.androidcourse.lab03.task2

import android.os.Bundle
import android.widget.Button

class Activity3 : BaseActivity(R.layout.fragment_3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.bnToFirst).setOnClickListener {
            setResult(Activity2.FROM_3_TO_1)
            finish()
        }

        findViewById<Button>(R.id.bnToSecond).setOnClickListener { finish() }
    }
}
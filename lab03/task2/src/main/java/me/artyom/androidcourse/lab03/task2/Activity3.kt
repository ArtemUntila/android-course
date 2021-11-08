package me.artyom.androidcourse.lab03.task2

import android.os.Bundle

class Activity3 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toThird.disappear()

        toFirst.setOnClickListener {
            setResult(Activity2.FROM_3_TO_1)
            finish()
        }

        toSecond.setOnClickListener { finish() }
    }
}
package me.artyom.androidcourse.lab03.task2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Activity2 : BaseActivity(R.layout.fragment_2) {

    companion object {
        const val FROM_3_TO_1 = 31
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //toSecond.disappear()

        findViewById<Button>(R.id.bnToFirst).setOnClickListener { finish() }

        findViewById<Button>(R.id.bnToThird).setOnClickListener {
            startActivityForResult(Intent(this, Activity3::class.java), 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("Second Activity", "req: $requestCode    res: $resultCode")
        if (resultCode == FROM_3_TO_1) finish()
        else super.onActivityResult(requestCode, resultCode, data)
    }
}
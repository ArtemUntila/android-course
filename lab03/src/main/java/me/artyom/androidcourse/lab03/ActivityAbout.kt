package me.artyom.androidcourse.lab03

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.artyom.androidcourse.lab03.task5.R

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<Button>(R.id.about_back).setOnClickListener {
            finish()
        }
    }
}
package me.artyom.androidcourse.lab03.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        findViewById<ImageButton>(R.id.about_back).setOnClickListener {
            finish()
        }
    }
}
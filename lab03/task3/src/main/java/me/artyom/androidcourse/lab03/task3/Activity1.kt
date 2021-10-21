package me.artyom.androidcourse.lab03.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        findViewById<TextView>(R.id.toolbar_label).text = "Activity 1"

        findViewById<ImageButton>(R.id.menu_button).setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }

        findViewById<Button>(R.id.to_second).setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }
}
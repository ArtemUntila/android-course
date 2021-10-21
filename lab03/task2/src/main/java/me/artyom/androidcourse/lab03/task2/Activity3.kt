package me.artyom.androidcourse.lab03.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        findViewById<TextView>(R.id.toolbar_label).text = "Activity 3"

        findViewById<ImageButton>(R.id.menu_button).setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }

        findViewById<Button>(R.id.to_first).setOnClickListener {
            setResult(Activity2.FROM_3_TO_1)
            finish()
        }

        findViewById<Button>(R.id.to_second).setOnClickListener {
            finish()
        }
    }
}
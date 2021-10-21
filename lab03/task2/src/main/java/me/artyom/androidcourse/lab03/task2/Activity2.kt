package me.artyom.androidcourse.lab03.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    companion object {
        const val FROM_3_TO_1 = 31
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        findViewById<TextView>(R.id.toolbar_label).text = "Activity 2"

        findViewById<ImageButton>(R.id.menu_button).setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }

        findViewById<Button>(R.id.to_first).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.to_third).setOnClickListener {
            startActivityForResult(Intent(this, Activity3::class.java), 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("Second Activity", "req: $requestCode    res: $resultCode")
        if (resultCode == FROM_3_TO_1) finish()
        else super.onActivityResult(requestCode, resultCode, data)
    }
}
package me.artyom.androidcourse.lab06.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private val src = "https://sun9-79.userapi.com/impg/9uc2d9alC2StG6TGEdM1GEb5HRCGBYsQhPJEng/" +
            "jvl0jkdboik.jpg?size=960x517&quality=96&sign=7542dbc27aa2ca31edbeae9e585699a4&type=album"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load(src).into(imageView)
        //Toast.makeText(this, "Hello, Glide", Toast.LENGTH_SHORT).show()
    }
}
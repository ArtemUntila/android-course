package me.artyom.androidcourse.lab06.task2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val src = "https://sun9-79.userapi.com/impg/9uc2d9alC2StG6TGEdM1GEb5HRCGBYsQhPJEng/" +
            "jvl0jkdboik.jpg?size=960x517&quality=96&sign=7542dbc27aa2ca31edbeae9e585699a4&type=album"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.executor.execute {
            //Thread.sleep(2000)
            val url = URL(src)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            runOnUiThread {
                findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)
            }
        }
        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }
}
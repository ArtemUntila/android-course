package me.artyom.androidcourse.lab06.task1.coroutines

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val LIFECYCLE_TAG = "MainActivity"
        const val COROUTINE_TAG = "Coroutine"
        const val SECONDS_ELAPSED = "me.artyom.androidcourse.lab06.task1.coroutines.secondsElapsed"
        const val ONE_SECOND: Long = 1000
    }

    private var secondsElapsed = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sPref: SharedPreferences

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ensure that UI-Thread is not blocked
        findViewById<Button>(R.id.button).setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sPref = getPreferences(MODE_PRIVATE)
        textSecondsElapsed.text = "Seconds elapsed: ${sPref.getInt(SECONDS_ELAPSED, 0)}"
    }

    override fun onPause() {
        super.onPause()
        Log.i(LIFECYCLE_TAG, "paused")
        job.cancel()
        sPref.edit().putInt(SECONDS_ELAPSED, secondsElapsed).apply()
    }

    override fun onResume() {
        super.onResume()
        Log.i(LIFECYCLE_TAG, "resumed")
        secondsElapsed = sPref.getInt(SECONDS_ELAPSED, 0)
        job = GlobalScope.launch {
            while (isActive) {
                delay(ONE_SECOND) // can't offer anything more accurate
                textSecondsElapsed.post { // Apply changes in UI-Thread
                    textSecondsElapsed.text = "Seconds elapsed: ${secondsElapsed++}"
                }
                Log.i(COROUTINE_TAG, Thread.currentThread().name)
            }
        }
    }

//    override fun onResume() {
//        super.onResume()
//        Log.i(LIFECYCLE_TAG, "resumed")
//        secondsElapsed = sPref.getInt(SECONDS_ELAPSED, 0)
//        job = GlobalScope.launch(Dispatchers.Main) {
//            while (isActive) {
//                delay(ONE_SECOND) // can't offer anything more accurate
//                textSecondsElapsed.text = "Seconds elapsed: ${secondsElapsed++}"
//                Log.i(COROUTINE_TAG, Thread.currentThread().name)
//            }
//        }
//    }
}
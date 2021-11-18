package me.artyom.androidcourde.lab06.task1.executorservice

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    companion object {
        const val LIFECYCLE_TAG = "MainActivity"
        const val SCHEDULER_TAG = "Scheduler"
        const val SECONDS_ELAPSED = "me.artyom.androidcourse.lab06.task1.secondsElapsed2"
    }

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sPref: SharedPreferences

    private lateinit var scheduledTask: ScheduledFuture<*>

    private val backgroundTask = Runnable {
        textSecondsElapsed.post { // Apply changes in UI-Thread
            textSecondsElapsed.text = "Seconds elapsed: ${secondsElapsed++}"
        }
        Log.i(SCHEDULER_TAG, Thread.currentThread().name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sPref = getPreferences(MODE_PRIVATE)
        textSecondsElapsed.text = "Seconds elapsed: ${sPref.getInt(SECONDS_ELAPSED, 0)}"
    }

    override fun onPause() {
        super.onPause()
        Log.i(LIFECYCLE_TAG, "paused")
        scheduledTask.cancel(true)
        sPref.edit().putInt(SECONDS_ELAPSED, secondsElapsed).apply()
    }

    override fun onResume() {
        super.onResume()
        Log.i(LIFECYCLE_TAG, "resumed")
        secondsElapsed = sPref.getInt(SECONDS_ELAPSED, 0)
        scheduledTask = MyApplication.scheduler.scheduleAtFixedRate(
            backgroundTask, 1, 1, TimeUnit.SECONDS
        )
    }
}
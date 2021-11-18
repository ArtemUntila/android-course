package me.artyom.androidcourse.lab06.task1.javathreads

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val LIFECYCLE_TAG = "MainActivity"
        const val THREAD_TAG = "Threads"
        const val SECONDS_ELAPSED = "me.artyom.androidcourse.lab06.task1.javathreads.secondsElapsed"
        const val ONE_SECOND: Long = 1000
    }

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sPref: SharedPreferences

    private lateinit var logTimer: LogTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(LIFECYCLE_TAG, "created")
        setContentView(R.layout.activity_main)

        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sPref = getPreferences(MODE_PRIVATE)
        textSecondsElapsed.text = "Seconds elapsed: ${sPref.getInt(SECONDS_ELAPSED, 0)}"
    }

    override fun onPause() {
        super.onPause()
        Log.i(LIFECYCLE_TAG, "paused")

        logTimer.cancel()
        sPref.edit().putInt(SECONDS_ELAPSED, secondsElapsed).apply()
    }

    override fun onResume() {
        super.onResume()
        Log.i(LIFECYCLE_TAG, "resumed")

        secondsElapsed = sPref.getInt(SECONDS_ELAPSED, 0)
        logTimer = LogTimer()
        logTimer.scheduleAtFixedRate(BackgroundTimerTask(), ONE_SECOND, ONE_SECOND)
    }

    inner class LogTimer : Timer() {
        override fun cancel() {
            super.cancel()
            Log.i(THREAD_TAG, "canceled")
        }

        override fun scheduleAtFixedRate(task: TimerTask?, delay: Long, period: Long) {
            super.scheduleAtFixedRate(task, delay, period)
            Log.i(THREAD_TAG, "started")
        }
    }

    inner class BackgroundTimerTask : TimerTask() {
        override fun run() {
            textSecondsElapsed.post { // Apply changes in UI-Thread
                textSecondsElapsed.text = "Seconds elapsed: ${secondsElapsed++}"
            }
            Log.i(THREAD_TAG, Thread.currentThread().name)
        }
    }
}
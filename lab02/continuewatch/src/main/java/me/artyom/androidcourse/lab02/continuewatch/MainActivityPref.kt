package me.artyom.androidcourse.lab02.continuewatch

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle

class MainActivityPref : AppCompatActivity()  {
    companion object {
        const val TAG = "MainActivity"
        const val SECONDS_STATE = "me.artyom.androidcourse.lab02.continuewatch.secondsElapsed"
    }

    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    lateinit var sPref: SharedPreferences
    var status = false

    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
                textSecondsElapsed.post {
                    textSecondsElapsed.setText("Seconds elapsed: ${secondsElapsed++}")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "created")
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sPref = getPreferences(MODE_PRIVATE)
        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "started")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "paused")
        status = false
        sPref.edit().putInt(SECONDS_STATE, secondsElapsed).apply()
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "resumed")
        status = true
        secondsElapsed = sPref.getInt(SECONDS_STATE, 0)
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "destroyed")
    }
}
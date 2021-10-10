package me.artyom.androidcourse.lab02.continuewatch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
        const val SECONDS_STATE = "secondsElapsed"
    }

    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView

    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.setText("Seconds elapsed: ${secondsElapsed++}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "created")
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "started")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "resumed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "restarted")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "paused")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "destroyed")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "saved")
        outState.putInt(SECONDS_STATE, secondsElapsed)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "restored")
        secondsElapsed = savedInstanceState.getInt(SECONDS_STATE)
    }
}
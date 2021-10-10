package me.artyom.androidcourse.lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "created")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "started")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "paused")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "stopped")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "restarted")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "destroyed")
    }
}
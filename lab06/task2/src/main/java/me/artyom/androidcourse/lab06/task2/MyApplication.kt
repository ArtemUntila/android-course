package me.artyom.androidcourse.lab06.task2

import android.app.Application
import java.util.concurrent.Executors.newSingleThreadExecutor

class MyApplication : Application() {
    companion object {
        val executor = newSingleThreadExecutor()
    }
}
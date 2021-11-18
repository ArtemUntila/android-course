package me.artyom.androidcourde.lab06.task1.executorservice

import android.app.Application
import java.util.concurrent.Executors.newSingleThreadScheduledExecutor

class MyApplication : Application() {
    companion object {
        val scheduler= newSingleThreadScheduledExecutor()
    }
}
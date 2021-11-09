package me.artyom.androidcourse.lab03.task3

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityContentTest {

    // Functions are separated to detect, which Activity has invalid content
    // or invalid behaviour after recreation
    @Test
    fun firstContentTest() {
        val scenario = launchActivity<Activity1>()
        firstIsDisplayed()
        scenario.recreate()
        firstIsDisplayed()
    }

    @Test
    fun secondContentTest() {
        val scenario = launchActivity<Activity2>()
        secondIsDisplayed()
        scenario.recreate()
        secondIsDisplayed()
    }

    @Test
    fun thirdContentTest() {
        val scenario = launchActivity<Activity3>()
        thirdIsDisplayed()
        scenario.recreate()
        thirdIsDisplayed()
    }
}

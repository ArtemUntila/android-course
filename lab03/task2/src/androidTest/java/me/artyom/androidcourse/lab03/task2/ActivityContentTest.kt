package me.artyom.androidcourse.lab03.task2

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityContentTest {

    // Functions are separated to detect, which Activity has invalid content
    // or invalid behaviour after recreation
    @Test
    fun firstRecreateTest() {
        val scenario = launchActivity<Activity1>()
        firstIsDisplayed()
        scenario.recreate()
        firstIsDisplayed()
    }

    @Test
    fun secondRecreateTest() {
        val scenario = launchActivity<Activity2>()
        secondIsDisplayed()
        scenario.recreate()
        secondIsDisplayed()
    }

    @Test
    fun thirdRecreateTest() {
        val scenario = launchActivity<Activity3>()
        thirdIsDisplayed()
        scenario.recreate()
        thirdIsDisplayed()
    }

    @Test
    fun firstContentTest() {
        val scenario = launchActivity<Activity1>()
        scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToSecond))
            Assert.assertNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNull(it.findViewById(R.id.bnToThird))
        }
    }

    @Test
    fun secondContentTest() {
        val scenario = launchActivity<Activity2>()
        scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNotNull(it.findViewById(R.id.bnToThird))
            Assert.assertNull(it.findViewById(R.id.bnToSecond))
        }
    }

    @Test
    fun thirdContentTest() {
        val scenario = launchActivity<Activity3>()
        scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNotNull(it.findViewById(R.id.bnToSecond))
            Assert.assertNull(it.findViewById(R.id.bnToThird))
        }
    }
}
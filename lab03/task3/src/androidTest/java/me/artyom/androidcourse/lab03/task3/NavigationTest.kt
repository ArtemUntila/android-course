package me.artyom.androidcourse.lab03.task3

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    private lateinit var scenario: ActivityScenario<Activity1>

    @Test
    fun testAbout() {
        scenario = launchActivity()
        openAbout()
        aboutIsDisplayed()

        pressBack()
        mainIsDisplayed()
        scenario.recreate()
        mainIsDisplayed()
        pressBackFromFirst()

        val aboutScenario = launchActivity<AboutActivity>()
        aboutIsDisplayed()
        aboutScenario.recreate()
        aboutIsDisplayed()
    }

    @Test
    fun testBackStack() {
        scenario = launchActivity()

        //First
        pressBackFromFirst()

        scenario = launchActivity()

        //Second
        toSecond()
        pressBack()
        firstIsDisplayed()

        toSecond()
        toFirst()
        pressBackFromFirst()

        scenario = launchActivity()

        //Third
        fromFirstToThird()
        pressBack()
        secondIsDisplayed()

        toThird()
        toSecond()
        pressBack()
        firstIsDisplayed()

        fromFirstToThird()
        toFirst()
        pressBackFromFirst()
    }

    @Test
    fun testButtonsNavigation() {
        scenario = launchActivity()

        //First
        firstIsDisplayed()
        toSecond()
        secondIsDisplayed()

        //Second
        toFirst()
        firstIsDisplayed()
        fromFirstToThird() //: toSecond() -> toThird()
        thirdIsDisplayed()

        //Third
        toFirst()
        firstIsDisplayed()
        fromFirstToThird()
        toSecond()
        secondIsDisplayed()
    }

    @Test
    fun testAboutNavigation() {
        scenario = launchActivity()

        //With default back button
        //First
        openAbout()
        aboutIsDisplayed()
        pressBack()
        firstIsDisplayed()
        pressBackFromFirst()

        scenario = launchActivity()

        //Second
        toSecond()
        openAbout()
        aboutIsDisplayed()
        pressBack()
        secondIsDisplayed()
        pressBack()
        firstIsDisplayed()

        //Third
        fromFirstToThird()
        openAbout()
        aboutIsDisplayed()
        pressBack()
        thirdIsDisplayed()
        pressBack()
        secondIsDisplayed()
    }

    private fun pressBackFromFirst() {
        pressBackUnconditionally() // avoid Exception
        Thread.sleep(1000)
        Assert.assertEquals(Lifecycle.State.DESTROYED, scenario.state)
    }
}
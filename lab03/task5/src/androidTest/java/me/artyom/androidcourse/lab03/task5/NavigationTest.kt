package me.artyom.androidcourse.lab03.task5

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

    private lateinit var scenario: ActivityScenario<MainActivity>

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
        firstIsAbsolutelyDisplayed()

        toSecond()
        toFirst()
        pressBackFromFirst()

        scenario = launchActivity()

        //Third
        fromFirstToThird()
        pressBack()
        secondIsAbsolutelyDisplayed()

        toThird()
        toSecond()
        pressBack()
        firstIsAbsolutelyDisplayed()

        fromFirstToThird()
        toFirst()
        pressBackFromFirst()
    }

    @Test
    fun testButtonsNavigation() {
        scenario = launchActivity()

        //First
        firstIsAbsolutelyDisplayed()
        toSecond()
        secondIsAbsolutelyDisplayed()

        //Second
        toFirst()
        firstIsAbsolutelyDisplayed()
        fromFirstToThird() //: toSecond() -> toThird()
        thirdIsAbsolutelyDisplayed()

        //Third
        toFirst()
        firstIsAbsolutelyDisplayed()
        fromFirstToThird()
        toSecond()
        secondIsAbsolutelyDisplayed()
    }

    @Test
    fun testAboutNavigation() {
        scenario = launchActivity()

        //With default back button
        //First
        openAbout()
        aboutIsDisplayed()
        pressBack()
        firstIsAbsolutelyDisplayed()
        pressBackFromFirst()

        scenario = launchActivity()

        //Second
        toSecond()
        openAbout()
        aboutIsDisplayed()
        pressBack()
        secondIsAbsolutelyDisplayed()
        pressBack()
        firstIsDisplayed()

        //Third
        fromFirstToThird()
        openAbout()
        aboutIsDisplayed()
        pressBack()
        thirdIsAbsolutelyDisplayed()
        pressBack()
        secondIsDisplayed()
    }

    @Test
    fun testActionBarNavigation() {
        scenario = launchActivity()

        //First
        openAbout()
        pressBackFromActionBar()
        firstIsAbsolutelyDisplayed()

        //Second
        toSecond()
        openAbout()
        pressBackFromActionBar()
        secondIsAbsolutelyDisplayed()
        pressBackFromActionBar()
        firstIsAbsolutelyDisplayed()
        pressBackFromFirst()

        scenario = launchActivity()

        //Third
        fromFirstToThird()
        openAbout()
        pressBackFromActionBar()
        thirdIsAbsolutelyDisplayed()
        pressBackFromActionBar()
        secondIsAbsolutelyDisplayed()
        toThird()
        toSecond()
        pressBackFromActionBar()
        firstIsAbsolutelyDisplayed()
    }

    private fun firstIsAbsolutelyDisplayed() {
        firstIsDisplayed()
        scenario.recreate()
        firstIsDisplayed()
    }

    private fun secondIsAbsolutelyDisplayed() {
        secondIsDisplayed()
        scenario.recreate()
        secondIsDisplayed()
    }

    private fun thirdIsAbsolutelyDisplayed() {
        thirdIsDisplayed()
        scenario.recreate()
        thirdIsDisplayed()
    }

    private fun pressBackFromFirst() {
        pressBackUnconditionally() // avoid Exception
        // In other cases state would be RESUMED
        Thread.sleep(1000)
        Assert.assertEquals(Lifecycle.State.DESTROYED, scenario.state)
    }
}
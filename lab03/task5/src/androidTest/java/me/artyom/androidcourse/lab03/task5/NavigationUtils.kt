package me.artyom.androidcourse.lab03.task5

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription

fun firstIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment1)
}

fun secondIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment2)
}

fun thirdIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment3)
}

fun mainIsDisplayed() = idIsDisplayed(R.id.drawer_layout)

fun aboutIsDisplayed() = idIsDisplayed(R.id.activity_about)

fun toFirst() = idClick(R.id.bnToFirst)

fun toSecond() = idClick(R.id.bnToSecond)

fun toThird() = idClick(R.id.bnToThird)

fun fromFirstToThird() {
    toSecond()
    toThird()
}

fun pressBackFromActionBar() {
    onView(withContentDescription(R.string.abc_action_bar_up_description))
        .perform(ViewActions.click())
}


fun idIsDisplayed(id: Int) {
    onView(ViewMatchers.withId(id))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}

fun idClick(id: Int) {
    onView(ViewMatchers.withId(id)).perform(ViewActions.click())
}

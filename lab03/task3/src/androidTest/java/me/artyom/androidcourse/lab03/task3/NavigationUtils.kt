package me.artyom.androidcourse.lab03.task3

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

fun firstIsDisplayed() {
    mainIsDisplayed()
    idIsGONE(R.id.bnToFirst)
    idIsDisplayed(R.id.bnToSecond)
    idIsGONE(R.id.bnToThird)
}

fun secondIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.bnToFirst)
    idIsGONE(R.id.bnToSecond)
    idIsDisplayed(R.id.bnToThird)
}

fun thirdIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.bnToFirst)
    idIsDisplayed(R.id.bnToSecond)
    idIsGONE(R.id.bnToThird)
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

fun idIsDisplayed(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun idClick(id: Int) {
    onView(withId(id)).perform(click())
}

fun idIsGONE(id: Int) {
    onView(withId(id)).check(matches(withEffectiveVisibility(Visibility.GONE)))
}
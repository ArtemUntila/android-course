package me.artyom.androidcourse.lab03.task3

import android.view.Gravity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers

private fun openAboutViaDrawer() {
    // Open Drawer to click on navigation.
    Espresso.onView(ViewMatchers.withId(R.id.drawer_layout))
        .check(ViewAssertions.matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
        .perform(DrawerActions.open()) // Open Drawer

    // Start the screen of your activity.
    Espresso.onView(ViewMatchers.withId(R.id.nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
}

fun openAbout() = openAboutViaDrawer()
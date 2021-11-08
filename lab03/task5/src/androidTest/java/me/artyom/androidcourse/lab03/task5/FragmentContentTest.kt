package me.artyom.androidcourse.lab03.task5

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentContentTest {

    @get: Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    // Functions are separated to detect, which Fragment has invalid content
    @Test
    fun firstContentTest() {
        activity.scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToSecond))
            Assert.assertNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNull(it.findViewById(R.id.bnToThird))
        }
    }

    @Test
    fun secondContentTest() {
        toSecond()
        activity.scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNotNull(it.findViewById(R.id.bnToThird))
            Assert.assertNull(it.findViewById(R.id.bnToSecond))
        }
    }

    @Test
    fun thirdContentTest() {
        fromFirstToThird()
        activity.scenario.onActivity {
            Assert.assertNotNull(it.findViewById(R.id.bnToFirst))
            Assert.assertNotNull(it.findViewById(R.id.bnToSecond))
            Assert.assertNull(it.findViewById(R.id.bnToThird))
        }
    }
}
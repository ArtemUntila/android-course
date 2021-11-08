package me.artyom.androidcourse.lab04

import android.widget.Button
import android.widget.EditText
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityContentTest {

    private val scenario = launchActivity<MainActivity>()

    @Test
    fun testMainActivityContent() {
        scenario.onActivity {
            assertNotNull(it.findViewById<EditText>(R.id.edit_text))
            assertNotNull(it.findViewById<Button>(R.id.button))
        }
    }

    @Test
    fun testButtonTextChange() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.edit_text)
            val button = it.findViewById<Button>(R.id.button)

            assertEquals("", editText.text.toString())
            button.performClick()
            assertEquals("", button.text.toString())
            assertEquals(editText.text, button.text)

            editText.setText("new")
            assertEquals("new", editText.text.toString())
            button.performClick()
            assertEquals("new", button.text.toString())
            assertEquals(editText.text, button.text)
        }
    }

    @Test
    fun testButtonTextReset() {
        val text = "Text"
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.edit_text)
            val button = it.findViewById<Button>(R.id.button)
            editText.setText(text)
            button.performClick()
        }
        scenario.recreate()
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.edit_text)
            val button = it.findViewById<Button>(R.id.button)
            assertEquals(text, editText.text.toString())
            assertEquals(it.getString(R.string.button_text), button.text)
        }
    }
}
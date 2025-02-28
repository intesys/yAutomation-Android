package it.intesys.yautomation.uiTestHelpers.pickers

import android.view.KeyEvent
import android.view.View
import android.widget.NumberPicker
import android.widget.Spinner
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Sets the value of a NumberPicker to a specific number.
 *
 * @param num The number to set in the NumberPicker.
 * @return A ViewAction that sets the specified number in the NumberPicker.
 */
fun YAutomation.Pickers.ViewActions.setNumberPickerNumber(num: Int): ViewAction {
    return object : ViewAction {
        override fun perform(uiController: UiController?, view: View) {
            val np = view as NumberPicker
            np.value = num
        }

        override fun getDescription(): String {
            return "Set the passed number into the NumberPicker"
        }

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(NumberPicker::class.java)
        }
    }
}

/**
 * Sets the value of a NumberPicker using its displayed value.
 *
 * @param value The displayed string value to set in the NumberPicker.
 * @return A ViewAction that selects the corresponding number based on the provided display value.
 */
fun YAutomation.Pickers.ViewActions.setNumberPickerDisplayValue(value: String): ViewAction {
    return object : ViewAction {
        override fun perform(uiController: UiController?, view: View) {
            val np = view as NumberPicker
            val displayedValues = np.displayedValues
            val newValue = displayedValues.indexOfFirst { it == value }

            if (newValue != -1) {
                val currentValue = np.value
                val diff = newValue - currentValue

                if (diff > 0) {
                    for (i in 1..diff) {
                        np.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN))
                        uiController?.loopMainThreadUntilIdle()
                    }
                } else if (diff < 0) {
                    for (i in 1..(-diff)) {
                        np.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP))
                        uiController?.loopMainThreadUntilIdle()
                    }
                }
                uiController?.loopMainThreadUntilIdle()
            } else {
                throw IllegalArgumentException("Value '$value' not found in NumberPicker displayed values")
            }
        }

        override fun getDescription(): String {
            return "Set the display value '$value' in the NumberPicker and trigger listeners"
        }

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(NumberPicker::class.java)
        }
    }
}

/**
 * Custom ViewAction to select an item in a Spinner by its text.
 *
 * @param value the value to select in the spinner.
 */
fun YAutomation.Pickers.ViewActions.selectSpinnerItemByName(value: String): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            // This can be customized to match any spinner-like view (e.g., using a Spinner, AutoCompleteTextView)
            return ViewMatchers.isAssignableFrom(Spinner::class.java)
        }

        override fun getDescription(): String {
            return "Select a spinner item by name: $value"
        }

        override fun perform(uiController: UiController?, view: View?) {
            val spinner = view as Spinner
            for (i in 0 until spinner.adapter.count) {
                if (spinner.adapter.getItem(i).toString() == value) {
                    spinner.setSelection(i) // Select the item
                    return
                }
            }
        }
    }
}



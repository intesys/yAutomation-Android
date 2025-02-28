package it.intesys.yautomation.uiTestHelpers.pickers

import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.espresso.matcher.ViewMatchers.withText
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Checks if the NumberPicker has the expected selected value.
 * @param viewMatcher Matcher for identifying the NumberPicker.
 * @param value The expected selected value.
 */
fun YAutomation.Pickers.checkNumberPickerSelectedValueIs(viewMatcher: Matcher<View>, value: String) {
    onView(
        allOf(
            isDescendantOfA(viewMatcher),
            isAssignableFrom(EditText::class.java)
        )
    ).check(matches(withText(value)))
}

/**
 * Checks if the NumberPicker has the expected selected value by view ID.
 * @param viewId The resource ID of the NumberPicker.
 * @param value The expected selected value.
 */
fun YAutomation.Pickers.checkNumberPickerSelectedValueIs(viewId: Int, value: String) {
    YAutomation.Pickers.checkNumberPickerSelectedValueIs(withId(viewId), value)
}

/**
 * Checks if the Spinner has the expected selected value.
 * @param viewInteraction ViewInteraction for identifying the Spinner.
 * @param value The expected selected value.
 */
fun YAutomation.Pickers.checkSpinnerSelectedValue(viewInteraction: ViewInteraction, value: String) {
    viewInteraction.check(matches(withSpinnerText(value)))
}

/**
 * Checks if the Spinner has the expected selected value.
 * @param viewMatcher Matcher for identifying the Spinner.
 * @param value The expected selected value.
 */
fun YAutomation.Pickers.checkSpinnerSelectedValue(viewMatcher: Matcher<View>, value: String) {
    YAutomation.Pickers.checkSpinnerSelectedValue(onView(viewMatcher), value)
}

/**
 * Checks if the Spinner has the expected selected value by view ID.
 * @param viewId The resource ID of the Spinner.
 * @param value The expected selected value.
 */
fun YAutomation.Pickers.checkSpinnerSelectedValue(viewId: Int, value: String) {
    YAutomation.Pickers.checkSpinnerSelectedValue(onView(withId(viewId)), value)
}

/**
 * Sets the selected value in a spinner view using the specified [ViewInteraction].
 *
 * @param viewInteraction the ViewInteraction instance that interacts with the spinner view.
 * @param value the value to select in the spinner.
 */
fun YAutomation.Pickers.setSpinnerSelectedValue(viewInteraction: ViewInteraction, value: String) {
    viewInteraction.perform(YAutomation.Pickers.ViewActions.selectSpinnerItemByName(value))
}

/**
 * Sets the selected value in a spinner view using the specified [Matcher].
 *
 * @param viewMatcher the Matcher instance that identifies the spinner view.
 * @param value the value to select in the spinner.
 */
fun YAutomation.Pickers.setSpinnerSelectedValue(viewMatcher: Matcher<View>, value: String) {
    YAutomation.Pickers.setSpinnerSelectedValue(onView(viewMatcher), value)
}

/**
 * Sets the selected value in a spinner view by using the view ID and the value to be selected.
 *
 * @param viewId the ID of the spinner view.
 * @param value the value to select in the spinner.
 */
fun YAutomation.Pickers.setSpinnerSelectedValue(viewId: Int, value: String) {
    YAutomation.Pickers.setSpinnerSelectedValue(onView(withId(viewId)), value)
}

/**
 * Sets the number in a number picker view using the specified [ViewInteraction].
 *
 * @param viewInteraction the ViewInteraction instance that interacts with the view.
 * @param num the number to set in the number picker.
 */
fun YAutomation.Pickers.setNumberPickerNumber(viewInteraction: ViewInteraction, num: Int) {
    viewInteraction.perform(YAutomation.Pickers.ViewActions.setNumberPickerNumber(num))
}

/**
 * Sets the number in a number picker view using the specified [Matcher].
 *
 * @param viewMatcher the Matcher instance that identifies the view.
 * @param num the number to set in the number picker.
 */
fun setNumberPickerNumber(viewMatcher: Matcher<View>, num: Int) {
    YAutomation.Pickers.setNumberPickerNumber(onView(viewMatcher), num)
}

/**
 * Sets the number in a number picker view by using the view ID and the number to be set.
 *
 * @param viewId the ID of the view.
 * @param num the number to set in the number picker.
 */
fun YAutomation.Pickers.setNumberPickerNumber(viewId: Int, num: Int) {
    YAutomation.Pickers.setNumberPickerNumber(onView(withId(viewId)), num)
}

/**
 * Sets the display value in a number picker view using the specified [ViewInteraction].
 *
 * @param viewInteraction the ViewInteraction instance that interacts with the view.
 * @param value the display value to set in the number picker.
 */
fun YAutomation.Pickers.setNumberPickerDisplayValue(viewInteraction: ViewInteraction, value: String) {
    viewInteraction.perform(YAutomation.Pickers.ViewActions.setNumberPickerDisplayValue(value))
}

/**
 * Sets the display value in a number picker view using the specified [Matcher].
 *
 * @param viewMatcher the Matcher instance that identifies the view.
 * @param value the display value to set in the number picker.
 */
fun YAutomation.Pickers.setNumberPickerDisplayValue(viewMatcher: Matcher<View>, value: String) {
    YAutomation.Pickers.setNumberPickerDisplayValue(onView(viewMatcher), value)
}

/**
 * Sets the display value in a number picker view by using the view ID and the value to be set.
 *
 * @param viewId the ID of the view.
 * @param value the display value to set in the number picker.
 */
fun YAutomation.Pickers.setNumberPickerDisplayValue(viewId: Int, value: String) {
    YAutomation.Pickers.setNumberPickerDisplayValue(onView(withId(viewId)), value)
}

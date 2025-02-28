package it.intesys.yautomation.uiTestHelpers.switches

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Checks if a Switch component is in the expected checked state.
 * @param viewInteraction ViewInteraction for identifying the Switch.
 * @param value The expected checked state (true for checked, false for unchecked).
 */
fun YAutomation.Switches.switchIs(viewInteraction: ViewInteraction, value: Boolean) {
    viewInteraction.check(matches(if (value) isChecked() else isNotChecked()))
}

/**
 * Checks if a Switch component is in the expected checked state.
 * @param viewMatcher Matcher for identifying the Switch.
 * @param value The expected checked state (true for checked, false for unchecked).
 */
fun YAutomation.Switches.switchIs(viewMatcher: Matcher<View>, value: Boolean) {
    switchIs(onView(viewMatcher), value)
}

/**
 * Checks if a Switch component is in the expected checked state by view ID.
 * @param switchId The resource ID of the Switch.
 * @param value The expected checked state (true for checked, false for unchecked).
 */
fun YAutomation.Switches.switchIs(switchId: Int, value: Boolean) {
    switchIs(withId(switchId), value)
}
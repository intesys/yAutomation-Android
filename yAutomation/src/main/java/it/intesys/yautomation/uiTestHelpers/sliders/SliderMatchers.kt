package it.intesys.yautomation.uiTestHelpers.sliders

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.slider.Slider
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Creates a matcher that verifies whether a Slider has the expected value.
 * @param expectedValue The expected float value of the Slider.
 * @return A Matcher that checks if the Slider's value matches the expected value.
 */
fun YAutomation.Sliders.Matchers.withValue(expectedValue: Float): Matcher<View> =
    object : BoundedMatcher<View, Slider>(Slider::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("expected: $expectedValue")
        }

        override fun matchesSafely(slider: Slider?): Boolean {
            return slider?.value == expectedValue
        }
}
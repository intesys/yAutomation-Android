package it.intesys.yautomation.uiTestHelpers.sliders

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Sets the value of a Slider component.
 * @param viewInteraction ViewInteraction for identifying the Slider.
 * @param value The value to be set on the Slider.
 */
fun YAutomation.Sliders.setSliderValue(viewInteraction: ViewInteraction, value: Float) {
    viewInteraction.perform(YAutomation.Sliders.ViewActions.setValue(value))
}

/**
 * Sets the value of a Slider component.
 * @param viewMatcher Matcher for identifying the Slider.
 * @param value The value to be set on the Slider.
 */
fun YAutomation.Sliders.setSliderValue(viewMatcher: Matcher<View>, value: Float) {
    YAutomation.Sliders.setSliderValue(onView(viewMatcher), value)
}

/**
 * Sets the value of a Slider component by view ID.
 * @param viewId The resource ID of the Slider.
 * @param value The value to be set on the Slider.
 */
fun YAutomation.Sliders.setSliderValue(viewId: Int, value: Float) {
    YAutomation.Sliders.setSliderValue(onView(withId(viewId)), value)
}
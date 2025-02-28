package it.intesys.yautomation.uiTestHelpers.sliders

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import com.google.android.material.slider.Slider
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Creates a ViewAction to set a specific value on a Slider component.
 * @param value The float value to set on the Slider.
 * @return A ViewAction that sets the given value on the Slider.
 */
fun YAutomation.Sliders.ViewActions.setValue(value: Float): ViewAction {
    return object : ViewAction {
        override fun getDescription(): String {
            return "Set Slider value to $value"
        }

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(Slider::class.java)
        }

        override fun perform(uiController: UiController?, view: View) {
            val seekBar = view as Slider
            seekBar.value = value
        }
    }
}
package it.intesys.yautomation.uiTestHelpers.textfields

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher

/**
 * Retrieves a ViewInteraction for a text field that supports input methods and is a descendant of the given view.
 * @param viewMatcher Matcher for identifying the parent view.
 * @return ViewInteraction instance for interacting with the text field.
 */
fun YAutomation.TextFields.ViewInteractions.onTextfieldView(viewMatcher: Matcher<View>): ViewInteraction {
    return onView(
        CoreMatchers.allOf(
            ViewMatchers.supportsInputMethods(),
            ViewMatchers.isDescendantOfA(viewMatcher)
        )
    )
}
package it.intesys.yautomation.uiTestHelpers.textfields

import android.view.View
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Types text into an EditText field that is a descendant of the specified view.
 * @param viewMatcher Matcher for identifying the parent view.
 * @param text The text to type into the EditText field.
 */
fun YAutomation.TextFields.typeOnEditText(viewMatcher: Matcher<View>, text: String) {
    YAutomation.TextFields.ViewInteractions.onTextfieldView(viewMatcher).perform(typeText(text))
}

/**
 * Types text into an EditText field by its view ID.
 * @param viewId The resource ID of the EditText field.
 * @param text The text to type into the EditText field.
 */
fun YAutomation.TextFields.typeOnEditText(viewId: Int, text: String) {
    YAutomation.TextFields.ViewInteractions.onTextfieldView(withId(viewId)).perform(typeText(text))
}
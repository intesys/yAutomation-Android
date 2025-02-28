package it.intesys.yautomation.uiTestHelpers.views

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Retrieves a ViewInteraction for a given view.
 * @param viewMatcher Matcher for identifying the view.
 * @return ViewInteraction instance for interacting with the view.
 */
fun YAutomation.Views.ViewInteractions.getView(viewMatcher: Matcher<View>): ViewInteraction {
    return onView(viewMatcher)
}

/**
 * Retrieves a ViewInteraction for a given view by view ID.
 * @param viewId The resource ID of the view.
 * @return ViewInteraction instance for interacting with the view.
 */
fun YAutomation.Views.ViewInteractions.getView(viewId: Int): ViewInteraction {
    return getView(withId(viewId))
}

/**
 * Retrieves a ViewInteraction for a view containing the given text.
 * @param text The text contained within the target view.
 * @return ViewInteraction instance for interacting with the view.
 */
fun YAutomation.Views.ViewInteractions.getViewWithText(text: String): ViewInteraction {
    return onView(withText(text))
}

/**
 * Retrieves the parent view of a view containing the given text.
 * @param text The text contained within the target child view.
 * @return ViewInteraction instance for interacting with the parent view.
 */
fun YAutomation.Views.ViewInteractions.getParentOfViewWithText(text: String): ViewInteraction {
    return onView(hasDescendant(withText(text)))
}

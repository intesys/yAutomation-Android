package it.intesys.yautomation.uiTestHelpers.searchbar

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Types text into a SearchView identified by ViewInteraction.
 * @param viewInteraction ViewInteraction for identifying the SearchView.
 * @param text The text to be entered.
 */
fun YAutomation.SearchBar.typeInSearchBar(viewInteraction: ViewInteraction, text: String) {
    viewInteraction.perform(YAutomation.SearchBar.ViewActions.typeSearchViewText(text))
}

/**
 * Types text into a SearchView identified by Matcher.
 * @param viewMatcher Matcher for identifying the SearchView.
 * @param text The text to be entered.
 */
fun YAutomation.SearchBar.typeInSearchBar(viewMatcher: Matcher<View>, text: String) {
    YAutomation.SearchBar.typeInSearchBar(onView(viewMatcher), text)
}

/**
 * Types text into a SearchView identified by view ID.
 * @param viewId The resource ID of the SearchView.
 * @param text The text to be entered.
 */
fun YAutomation.SearchBar.typeInSearchBar(viewId: Int, text: String) {
    YAutomation.SearchBar.typeInSearchBar(withId(viewId), text)
}

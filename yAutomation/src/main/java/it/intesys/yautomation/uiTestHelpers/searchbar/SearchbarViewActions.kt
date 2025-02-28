package it.intesys.yautomation.uiTestHelpers.searchbar

import android.view.View
import android.widget.SearchView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Creates a ViewAction to type text into a SearchView.
 * @param text The text to be entered into the SearchView.
 * @return A ViewAction that sets the query in the SearchView without submitting it.
 */
fun YAutomation.SearchBar.ViewActions.typeSearchViewText(text: String): ViewAction {
    return object : ViewAction {
        override fun getDescription(): String {
            return "Change view text"
        }

        override fun getConstraints(): Matcher<View> {
            return allOf(isDisplayed(), isAssignableFrom(SearchView::class.java))
        }

        override fun perform(uiController: UiController?, view: View?) {
            (view as SearchView).setQuery(text, false)
        }
    }
}
package it.intesys.yautomation.uiTestHelpers.snackbars

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

/**
 * Returns a Matcher for identifying the text view within a Snackbar.
 * @return A Matcher that locates the Snackbar's text view using its resource ID.
 */
fun YAutomation.Snackbars.Matchers.snackbarText(): Matcher<View>? {
    return withId(com.google.android.material.R.id.snackbar_text)
}
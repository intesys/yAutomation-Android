package it.intesys.yautomation.uiTestHelpers.views

import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.util.TreeIterables
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Matches a view's background color against the expected color resource.
 * @param expectedResourceId The resource ID of the expected background color.
 * @return A Matcher<View> that checks if the background color matches the expected value.
 */
fun YAutomation.Matchers.matchesBackgroundColor(expectedResourceId: Int): Matcher<View> {
    return object : BoundedMatcher<View, View>(View::class.java) {
        var actualColor: Int = 0
        var expectedColor: Int = 0
        var message: String? = null

        override fun matchesSafely(item: View): Boolean {
            if (item.background == null) {
                message = "${item.id} does not have a background"
                return false
            }
            val resources: Resources = item.context.resources
            expectedColor = ResourcesCompat.getColor(resources, expectedResourceId, null)

            actualColor = try {
                (item.background as ColorDrawable).color
            } catch (e: Exception) {
                (item.background as GradientDrawable).color!!.defaultColor
            } finally {
                if (actualColor == expectedColor) {
                    println(
                        "Success: Expected Color ${
                            String.format("#%06X", (0xFFFFFF and expectedColor))
                        }, Actual Color ${
                            String.format("#%06X", (0xFFFFFF and actualColor))
                        }"
                    )
                }
            }
            return actualColor == expectedColor
        }

        override fun describeTo(description: Description) {
            if (actualColor != 0) {
                message = "Background color did not match: Expected ${
                    String.format("#%06X", (0xFFFFFF and expectedColor))
                }, but was ${
                    String.format("#%06X", (0xFFFFFF and actualColor))
                }"
            }
            description.appendText(message)
        }
    }
}

/**
 * Matches a view that contains a specified number of child views that match the given matcher.
 * @param viewMatcher The matcher for the views being counted.
 * @param expectedCount The expected number of matching views.
 * @param orMore If true, allows matching views to be at least the expected count.
 * @return A TypeSafeMatcher<View> that checks the count of views matching the given matcher.
 */
fun YAutomation.Matchers.withViewCount(viewMatcher: Matcher<View>, expectedCount: Int, orMore: Boolean = false): TypeSafeMatcher<View?> {
    return object : TypeSafeMatcher<View?>() {
        private var actualCount = -1

        override fun describeTo(description: Description) {
            if (actualCount >= 0) {
                description.appendText("Expected items count: $expectedCount, but got: $actualCount")
            }
        }

        override fun matchesSafely(root: View?): Boolean {
            actualCount = TreeIterables.breadthFirstViewTraversal(root).count {
                viewMatcher.matches(it)
            }
            return if (orMore) expectedCount <= actualCount else expectedCount == actualCount
        }
    }
}

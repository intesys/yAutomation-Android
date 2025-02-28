package it.intesys.yautomation.uiTestHelpers.recyclerViews

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import androidx.test.espresso.ViewAssertion
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString

/**
 * Creates a {@link ViewAssertion} that verifies all visible items in a {@link RecyclerView}
 * contain the specified text within a given TextView.
 *
 * This assertion checks only the currently visible items in the RecyclerView,
 * not the entire dataset. If an item does not contain the expected text,
 * the assertion will fail.
 *
 * @param itemTextViewId The resource ID of the TextView inside each RecyclerView item.
 * @param text The text that each visible item's TextView should contain.
 * @return A ViewAssertion that can be used with Espresso's `check()` method.
 * @throws IllegalStateException If the provided view is not a RecyclerView or has no adapter.
 *
 * Usage example:
 * ```
 * onView(withId(R.id.recyclerView))
 *     .check(UITestHelpers.RecyclerViews.Assertions.allItemsContainText(R.id.itemTextView, "Expected Text"))
 * ```
 */
fun YAutomation.RecyclerViews.Assertions.allItemsContainText(itemTextViewId: Int, text: String): ViewAssertion {
    return ViewAssertion { view, _ ->
        if (view is RecyclerView) {
            val adapter = view.adapter ?: throw IllegalStateException("RecyclerView has no adapter")
            val visibleItemCount = view.childCount

            for (i in 0 until visibleItemCount) {
                val childView = view.getChildAt(i)
                val textView = childView.findViewById<TextView>(itemTextViewId)
                assertThat(
                    "Item at position $i does not contain the filter text",
                    textView.text.toString(),
                    containsString(text)
                )
            }
        } else {
            throw IllegalStateException("The provided view is not a RecyclerView")
        }
    }
}
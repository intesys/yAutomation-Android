package it.intesys.yautomation.uiTestHelpers.recyclerViews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher

import org.hamcrest.Matchers.allOf

/**
 * Scrolls to an item containing specific text in a RecyclerView.
 * @param viewInteraction ViewInteraction for identifying the RecyclerView.
 * @param text The text contained in the target item.
 */
fun YAutomation.RecyclerViews.scrollToItemContainingText(viewInteraction: ViewInteraction, text: String) {
    viewInteraction.perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(hasDescendant(withText(text))))
}

/**
 * Scrolls to an item containing specific text in a RecyclerView.
 * @param viewMatcher Matcher for identifying the RecyclerView.
 * @param text The text contained in the target item.
 */
fun YAutomation.RecyclerViews.scrollToItemContainingText(viewMatcher: Matcher<View>, text: String) {
    YAutomation.RecyclerViews.scrollToItemContainingText(onView(viewMatcher), text)
}

/**
 * Scrolls to an item containing specific text in a RecyclerView by view ID.
 * @param viewId The resource ID of the RecyclerView.
 * @param text The text contained in the target item.
 */
fun YAutomation.RecyclerViews.scrollToItemContainingText(viewId: Int, text: String) {
    YAutomation.RecyclerViews.scrollToItemContainingText(onView(withId(viewId)), text)
}

/**
 * Scrolls to a specific position in a RecyclerView.
 * @param viewInteraction ViewInteraction for identifying the RecyclerView.
 * @param position The target position to scroll to.
 */
fun YAutomation.RecyclerViews.scrollToPosition(viewInteraction: ViewInteraction, position: Int) {
    viewInteraction.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
}

/**
 * Scrolls to a specific position in a RecyclerView.
 * @param viewMatcher Matcher for identifying the RecyclerView.
 * @param position The target position to scroll to.
 */
fun YAutomation.RecyclerViews.scrollToPosition(viewMatcher: Matcher<View>, position: Int) {
    YAutomation.RecyclerViews.scrollToPosition(onView(viewMatcher), position)
}

/**
 * Scrolls to a specific position in a RecyclerView by view ID.
 * @param viewId The resource ID of the RecyclerView.
 * @param position The target position to scroll to.
 */
fun YAutomation.RecyclerViews.scrollToPosition(viewId: Int, position: Int) {
    YAutomation.RecyclerViews.scrollToPosition(onView(withId(viewId)), position)
}

/**
 * Taps an item containing specific text in a RecyclerView.
 * @param viewInteraction ViewInteraction for identifying the RecyclerView.
 * @param text The text of the item to tap.
 */
fun YAutomation.RecyclerViews.tapFromList(viewInteraction: ViewInteraction, text: String) {
    YAutomation.RecyclerViews.scrollToItemContainingText(viewInteraction, text)
    onView(withText(text)).perform(click())
}

/**
 * Taps an item containing specific text in a RecyclerView.
 * @param viewMatcher Matcher for identifying the RecyclerView.
 * @param text The text of the item to tap.
 */
fun YAutomation.RecyclerViews.tapFromList(viewMatcher: Matcher<View>, text: String) {
    YAutomation.RecyclerViews.tapFromList(onView(viewMatcher), text)
}

/**
 * Taps an item containing specific text in a RecyclerView by view ID.
 * @param viewId The resource ID of the RecyclerView.
 * @param text The text of the item to tap.
 */
fun YAutomation.RecyclerViews.tapFromList(viewId: Int, text: String) {
    YAutomation.RecyclerViews.tapFromList(onView(withId(viewId)), text)
}

/**
 * Checks if an item with specific text is selected and visible in a RecyclerView.
 * @param viewMatcher Matcher for identifying the RecyclerView.
 * @param text The text of the item that should be selected.
 */
fun YAutomation.RecyclerViews.itemWithTextIsSelected(viewMatcher: Matcher<View>, text: String) {
    onView(allOf(
        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
        viewMatcher,
        isDescendantOfA(hasDescendant(withText(text)))
    )).check(matches(isDisplayed()))
}

/**
 * Checks if an item with specific text is selected and visible in a RecyclerView by view ID.
 * @param viewId The resource ID of the RecyclerView.
 * @param text The text of the item that should be selected.
 */
fun YAutomation.RecyclerViews.itemWithTextIsSelected(viewId: Int, text: String) {
    YAutomation.RecyclerViews.itemWithTextIsSelected(withId(viewId), text)
}

/**
 * Verifies that all items in a RecyclerView contain specific text.
 * @param viewInteraction ViewInteraction for identifying the RecyclerView.
 * @param itemTextViewId The resource ID of the TextView within the items.
 * @param text The expected text in each item.
 */
fun YAutomation.RecyclerViews.allItemsContainTextInView(viewInteraction: ViewInteraction, itemTextViewId: Int, text: String) {
    viewInteraction.check(YAutomation.RecyclerViews.Assertions.allItemsContainText(itemTextViewId, text))
}

/**
 * Verifies that all items in a RecyclerView contain specific text.
 * @param viewMatcher Matcher for identifying the RecyclerView.
 * @param itemTextViewId The resource ID of the TextView within the items.
 * @param text The expected text in each item.
 */
fun YAutomation.RecyclerViews.allItemsContainTextInView(viewMatcher: Matcher<View>, itemTextViewId: Int, text: String) {
    YAutomation.RecyclerViews.allItemsContainTextInView(onView(viewMatcher), itemTextViewId, text)
}

/**
 * Verifies that all items in a RecyclerView contain specific text by view ID.
 * @param viewId The resource ID of the RecyclerView.
 * @param itemTextViewId The resource ID of the TextView within the items.
 * @param text The expected text in each item.
 */
fun YAutomation.RecyclerViews.allItemsContainTextInView(viewId: Int, itemTextViewId: Int, text: String) {
    YAutomation.RecyclerViews.allItemsContainTextInView(withId(viewId), itemTextViewId, text)
}
package it.intesys.yautomation.uiTestHelpers.views

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher
import org.hamcrest.Matchers.instanceOf


/**
 * Checks if a view is displayed on the screen.
 * @param viewInteraction ViewInteraction for identifying the view.
 */
fun YAutomation.Views.isDisplayed(viewInteraction: ViewInteraction) {
    viewInteraction.check(matches(isDisplayed()))
}

/**
 * Checks if a view is displayed on the screen.
 * @param viewMatcher Matcher for identifying the view.
 */
fun YAutomation.Views.isDisplayed(viewMatcher: Matcher<View>) {
    YAutomation.Views.isDisplayed(onView(viewMatcher))
}

/**
 * Checks if a view is displayed on the screen by view ID.
 * @param viewId The resource ID of the view.
 */
fun YAutomation.Views.isDisplayed(viewId: Int) {
    YAutomation.Views.isDisplayed(withId(viewId))
}

/**
 * Checks if a view is visible (not gone or invisible).
 * @param viewInteraction ViewInteraction for identifying the view.
 */
fun YAutomation.Views.isVisible(viewInteraction: ViewInteraction) {
    viewInteraction.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

/**
 * Checks if a view is visible (not gone or invisible).
 * @param viewMatcher Matcher for identifying the view.
 */
fun YAutomation.Views.isVisible(viewMatcher: Matcher<View>) {
    YAutomation.Views.isVisible(onView(viewMatcher))
}

/**
 * Checks if a view is visible (not gone or invisible) by view ID.
 * @param viewId The resource ID of the view.
 */
fun YAutomation.Views.isVisible(viewId: Int) {
    YAutomation.Views.isVisible(withId(viewId))
}

/**
 * Performs a tap action on a view.
 * @param viewInteraction ViewInteraction for identifying the view.
 */
fun YAutomation.Views.tap(viewInteraction: ViewInteraction) {
    viewInteraction.perform(click())
}

/**
 * Performs a tap action on a view.
 * @param viewMatcher Matcher for identifying the view.
 */
fun YAutomation.Views.tap(viewMatcher: Matcher<View>) {
    YAutomation.Views.tap(onView(viewMatcher))
}

/**
 * Performs a tap action on a view by view ID.
 * @param viewId The resource ID of the view.
 */
fun YAutomation.Views.tap(viewId: Int) {
    YAutomation.Views.tap(withId(viewId))
}

/**
 * Performs a tap action on a view containing the given text.
 * @param text The text contained within the target view.
 */
fun YAutomation.Views.tap(text: String) {
    onView(withText(text)).perform(click())
}

/**
 * Checks if a view contains the expected number of subviews of a given class.
 * @param viewInteraction ViewInteraction for identifying the parent view.
 * @param viewClass The class type of the expected subviews.
 * @param count The expected number of subviews.
 * @param orMore If true, checks if there are at least the given number of subviews.
 */
fun <T> YAutomation.hasViewWithClass(
    viewInteraction: ViewInteraction,
    viewClass: Class<T>,
    count: Int,
    orMore: Boolean = false
) {
    viewInteraction.check(matches(YAutomation.Matchers.withViewCount(instanceOf(viewClass), count, orMore)))
}

/**
 * Checks if a view contains the expected number of subviews of a given class.
 * @param viewMatcher Matcher for identifying the parent view.
 * @param viewClass The class type of the expected subviews.
 * @param count The expected number of subviews.
 * @param orMore If true, checks if there are at least the given number of subviews.
 */
fun <T> YAutomation.hasViewWithClass(
    viewMatcher: Matcher<View>,
    viewClass: Class<T>,
    count: Int,
    orMore: Boolean = false
) {
    hasViewWithClass(onView(viewMatcher), viewClass, count, orMore)
}

/**
 * Checks if a view contains the expected number of subviews of a given class by view ID.
 * @param viewId The resource ID of the parent view.
 * @param viewClass The class type of the expected subviews.
 * @param count The expected number of subviews.
 * @param orMore If true, checks if there are at least the given number of subviews.
 */
fun <T> YAutomation.hasViewWithClass(
    viewId: Int,
    viewClass: Class<T>,
    count: Int,
    orMore: Boolean = false
) {
    hasViewWithClass(withId(viewId), viewClass, count, orMore)
}

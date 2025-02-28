package it.intesys.yautomation.uiTestHelpers.wait

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Matcher
import org.hamcrest.core.StringContains.containsString

/**
 * Waits until a view containing the specified text appears on the screen within the given timeout.
 *
 * This function is useful for testing scenarios where text dynamically appears due to
 * network requests, loading screens, or delayed UI updates.
 *
 * @param text The text to wait for in the view hierarchy.
 * @param exactMatch If `true`, waits for a view that exactly matches the given text.
 *                   If `false`, waits for a view that contains the text as a substring.
 *                   Default is `true`.
 * @param timeout The maximum time (in milliseconds) to wait for the text to appear. Default is 5000ms.
 *
 * @throws PerformException if the text does not appear within the specified timeout.
 *
 * Usage example:
 * ```
 * // Wait for exact text match
 * YAutomation.Wait.waitUntilTextAppear("Welcome")
 *
 * // Wait for text containing a specific word
 * YAutomation.Wait.waitUntilTextAppear("Loading", exactMatch = false)
 * ```
 */
fun YAutomation.Wait.waitUntilTextAppear(text: String, exactMatch: Boolean = true, timeout: Long = 5000) {
    if (exactMatch) {
        YAutomation.Wait.waitUntilViewAppears(withText(text))
    } else {
        YAutomation.Wait.waitUntilViewAppears(withText(containsString(text)))
    }
}

/**
 * Waits until a view with the provided `ViewInteraction` becomes visible within the given timeout.
 *
 * This version allows reusability for any `ViewInteraction`, enabling flexibility in waiting for views.
 *
 * @param viewInteraction The `ViewInteraction` of the view to wait for.
 * @param timeout The maximum time (in milliseconds) to wait for the view to become visible. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsVisible(viewInteraction: ViewInteraction, timeout: Long = 5000) {
    viewInteraction.perform(YAutomation.Wait.ViewActions.waitUntilVisible(timeout))
}

/**
 * Waits until a view that matches the provided `Matcher<View>` becomes visible within the given timeout.
 *
 * This version allows you to match views with more flexibility, such as multiple views or complex criteria.
 *
 * @param viewMatcher The `Matcher<View>` to match the view.
 * @param timeout The maximum time (in milliseconds) to wait for the view to become visible. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsVisible(viewMatcher: Matcher<View>, timeout: Long = 5000) {
    YAutomation.Wait.waitUntilViewIsVisible(onView(viewMatcher), timeout)
}

/**
 * Waits until a view performs a specific action (like visibility) within the given timeout.
 *
 * This version is more flexible and allows you to pass a custom `ViewAction` if needed.
 *
 * @param viewId The resource ID of the view to wait for.
 * @param timeout The maximum time (in milliseconds) to wait for the view action to be performed. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsVisible(viewId: Int, timeout: Long = 5000) {
    YAutomation.Wait.waitUntilViewIsVisible(onView(withId(viewId)), timeout)
}

/**
 * Waits until a view with the provided `ViewInteraction` becomes gone within the given timeout.
 *
 * This version allows reusability for any `ViewInteraction`, enabling flexibility in waiting for views.
 *
 * @param viewInteraction The `ViewInteraction` of the view to wait for.
 * @param timeout The maximum time (in milliseconds) to wait for the view to become gone. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsGone(viewInteraction: ViewInteraction, timeout: Long = 5000) {
    viewInteraction.perform(YAutomation.Wait.ViewActions.waitUntilGone(timeout))
}

/**
 * Waits until a view that matches the provided `Matcher<View>` becomes gone within the given timeout.
 *
 * This version allows you to match views with more flexibility, such as multiple views or complex criteria.
 *
 * @param viewMatcher The `Matcher<View>` to match the view.
 * @param timeout The maximum time (in milliseconds) to wait for the view to become gone. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsGone(viewMatcher: Matcher<View>, timeout: Long = 5000) {
    YAutomation.Wait.waitUntilViewIsGone(onView(viewMatcher), timeout)
}

/**
 * Waits until a view performs a specific action (like disappearance) within the given timeout.
 *
 * This version is more flexible and allows you to pass a custom `ViewAction` if needed.
 *
 * @param viewId The resource ID of the view to wait for.
 * @param timeout The maximum time (in milliseconds) to wait for the view action to be performed. Default is 5000ms.
 */
fun YAutomation.Wait.waitUntilViewIsGone(viewId: Int, timeout: Long = 5000) {
    YAutomation.Wait.waitUntilViewIsGone(onView(withId(viewId)), timeout)
}

/**
 * Waits until a view containing the specified text becomes visible within the given timeout.
 *
 * This function waits for a view that either exactly matches or contains the specified text,
 * depending on the value of `exactMatch`. It ensures that the view with the desired text
 * is displayed on the screen during testing.
 *
 * @param text The text to wait for in the view hierarchy.
 * @param exactMatch If `true`, waits for a view that exactly matches the given text.
 *                   If `false`, waits for a view that contains the text as a substring. Default is `true`.
 * @param timeout The maximum time (in milliseconds) to wait for the text to appear. Default is 5000ms.
 *
 * @throws PerformException if the text does not appear within the specified timeout.
 *
 * Usage example:
 * ```
 * // Wait for exact text match
 * YAutomation.Wait.waitUntilTextIsVisible("Welcome")
 *
 * // Wait for text containing a specific word
 * YAutomation.Wait.waitUntilTextIsVisible("Loading", exactMatch = false)
 * ```
 */
fun YAutomation.Wait.waitUntilTextIsVisible(text: String, exactMatch: Boolean = true, timeout: Long = 5000) {
    if (exactMatch) {
        onView(
            withText(text)
        ).perform(YAutomation.Wait.ViewActions.waitUntilVisible(timeout))
    } else {
        onView(
            withText(containsString(text))
        ).perform(YAutomation.Wait.ViewActions.waitUntilVisible(timeout))
    }
}



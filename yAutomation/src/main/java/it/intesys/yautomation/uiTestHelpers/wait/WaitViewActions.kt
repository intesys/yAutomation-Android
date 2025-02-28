package it.intesys.yautomation.uiTestHelpers.wait

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.util.HumanReadables
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import java.lang.Thread.sleep
import java.util.concurrent.TimeoutException


/**
 * Creates a {@link ViewAction} that waits until a view becomes visible within the specified timeout.
 *
 * This function is useful in cases where UI elements take time to appear due to animations,
 * network requests, or delayed rendering. It internally calls `waitUntilVisibilityIs(View.VISIBLE, timeout)`.
 *
 * @param timeout The maximum time to wait (in milliseconds) for the view to become visible. Default is 5000ms.
 * @return A {@link ViewAction} that waits for the view to be visible before proceeding.
 *
 * Usage example:
 * ```
 * onView(withId(R.id.someView)).perform(YAutomation.waitUntilVisible(3000))
 * ```
 */
fun YAutomation.Wait.ViewActions.waitUntilVisible(timeout: Long = 5000): ViewAction {
    return YAutomation.Wait.ViewActions.waitUntilVisibilityIs(View.VISIBLE, timeout)
}

/**
 * Creates a {@link ViewAction} that waits until a view becomes completely gone (not visible)
 * within the specified timeout.
 *
 * This function is useful for scenarios where elements disappear due to animations,
 * loading indicators, or dynamic UI updates.
 *
 * @param timeout The maximum time (in milliseconds) to wait for the view to disappear. Default is 5000ms.
 * @return A {@link ViewAction} that waits for the view to be gone before proceeding.
 *
 * Usage example:
 * ```
 * onView(withId(R.id.someView)).perform(YAutomation.Wait.ViewActions.waitUntilGone(3000))
 * ```
 */
fun YAutomation.Wait.ViewActions.waitUntilGone(timeout: Long = 5000): ViewAction {
    return YAutomation.Wait.ViewActions.waitUntilVisibilityIs(View.GONE, timeout)
}

/**
 * Creates a {@link ViewAction} that waits until a view reaches the specified visibility state
 * (e.g., {@link View#VISIBLE}, {@link View#GONE}, or {@link View#INVISIBLE}) within the given timeout.
 *
 * This is useful when testing dynamic UI elements that change visibility based on interactions
 * or asynchronous events.
 *
 * @param visibility The desired visibility state (View.VISIBLE, View.GONE, or View.INVISIBLE).
 * @param timeout The maximum time (in milliseconds) to wait for the view to reach the desired visibility. Default is 5000ms.
 * @return A {@link ViewAction} that waits for the specified visibility state.
 *
 * @throws PerformException if the timeout is reached before the view changes visibility.
 *
 * Usage example:
 * ```
 * onView(withId(R.id.someView)).perform(YAutomation.Wait.ViewActions.waitUntilVisibilityIs(View.VISIBLE, 3000))
 * ```
 */
fun YAutomation.Wait.ViewActions.waitUntilVisibilityIs(visibility: Int, timeout: Long = 5000): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return CoreMatchers.any(View::class.java)
        }

        override fun getDescription(): String {
            return "wait up to $timeout milliseconds for the view to be $visibility"
        }

        override fun perform(uiController: UiController, view: View) {
            val endTime = System.currentTimeMillis() + timeout
            do {
                if (view.visibility == visibility) return
                uiController.loopMainThreadForAtLeast(50)
            } while (System.currentTimeMillis() < endTime)
            throw PerformException.Builder()
                .withActionDescription(description)
                .withCause(TimeoutException("Waited $timeout milliseconds"))
                .withViewDescription(HumanReadables.describe(view))
                .build()
        }
    }
}

/**
 * Recursively waits for a view to appear within a specified timeout.
 *
 * This function continuously checks if a view matching the given matcher is displayed.
 * If the view does not appear within the timeout, an exception is thrown.
 *
 * @param view The Espresso {@link Matcher<View>} to locate the desired view.
 * @param timeout The maximum time (in milliseconds) to wait for the view to appear. Default is 5000ms.
 * @param waitMillisPerTry The delay (in milliseconds) between each check. Default is 100ms.
 * @param endTime The absolute time (in milliseconds) when the waiting should stop.
 *
 * @throws PerformException if the view does not appear within the specified timeout.
 *
 * Usage example:
 * ```
 * YAutomation.Wait.waitUntilViewAppears(withId(R.id.someView))
 * ```
 */
fun YAutomation.Wait.waitUntilViewAppears(
    view: Matcher<View>,
    timeout: Long = 5000,
    waitMillisPerTry: Long = 100,
    endTime: Long = System.currentTimeMillis() + timeout
) {
    try {
        onView(view).check(matches(isDisplayed()))
    } catch (e: Exception) {
        if (System.currentTimeMillis() > endTime) {
            throw PerformException.Builder()
                .withActionDescription("Error finding a view matching criteria")
                .withCause(TimeoutException("Waited $timeout milliseconds"))
                .withViewDescription("view $view")
                .build()
        } else {
            sleep(waitMillisPerTry)
            waitUntilViewAppears(view = view, endTime = endTime)
        }
    }
}




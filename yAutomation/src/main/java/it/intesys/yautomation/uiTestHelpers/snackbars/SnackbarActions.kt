package it.intesys.yautomation.uiTestHelpers.snackbars

import androidx.test.espresso.matcher.ViewMatchers.withText
import it.intesys.yautomation.uiTestHelpers.YAutomation
import it.intesys.yautomation.uiTestHelpers.wait.waitUntilViewAppears
import org.hamcrest.CoreMatchers.allOf

/**
 * Waits until a Snackbar with the specified text appears within the given timeout.
 * @param text The expected text in the Snackbar. If null, it will wait for any Snackbar to appear.
 * @param timeout The maximum time (in milliseconds) to wait for the Snackbar to appear. Default is 5000ms.
 */
fun YAutomation.Snackbars.waitUntilSnackbarAppears(text: String? = null, timeout: Long = 5000) {
    YAutomation.Wait.waitUntilViewAppears(allOf(YAutomation.Snackbars.Matchers.snackbarText(),withText(text)), timeout)
}
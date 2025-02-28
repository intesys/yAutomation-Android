package it.intesys.yautomation.uiTestHelpers.menus

import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.platform.app.InstrumentationRegistry
import it.intesys.yautomation.uiTestHelpers.YAutomation

/**
 * Opens a kebab menu.
 */
fun YAutomation.openKebabMenu() {
    openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
}
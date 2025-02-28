package it.intesys.yautomation.uiTestHelpers

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

/**
 * An utility object containing helper functions and nested objects for UI testing with Espresso.
 *
 * This object provides various utilities for interacting with UI elements,
 * performing assertions, and improving test reliability.
 */
object YAutomation {

    /**
     * Enables or disables system animations programmatically.
     *
     * Disabling animations before running UI tests helps improve stability and speed,
     * preventing flakiness caused by transition delays. It is recommended to re-enable
     * animations after test execution to restore the default device behavior.
     *
     * @param enable `true` to enable animations, `false` to disable them.
     */
    fun changeAnimationStatus(enable: Boolean = true) {
        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
            executeShellCommand("settings put global transition_animation_scale ${if (enable) 1 else 0}")
            executeShellCommand("settings put global window_animation_scale ${if (enable) 1 else 0}")
            executeShellCommand("settings put global animator_duration_scale ${if (enable) 1 else 0}")
        }
    }

    /** Object for custom Espresso matchers. */
    object Matchers

    /** Contains helpers related to DatePicker interactions. */
    object DatePickers {
        /** Custom matchers for DatePickers. */
        object Matchers

        /** Utility functions for DatePickers. */
        object Utilities

        /** Custom interactions for DatePickers. */
        object ViewInteractions
    }

    /** Contains utilities for ImageView interactions. */
    object ImageViews

    /** Contains helpers for interacting with NumberPickers and other similar controls. */
    object Pickers {
        /** Custom ViewActions for Pickers. */
        object ViewActions
    }

    /** Contains assertions for RecyclerView items and behavior. */
    object RecyclerViews {
        /** Custom assertions for RecyclerViews. */
        object Assertions
    }

    /** Contains helper methods for interacting with the SearchBar widget. */
    object SearchBar {
        /** Custom ViewActions for SearchBars. */
        object ViewActions
    }

    /** Contains utilities for interacting with Sliders. */
    object Sliders {
        /** Custom ViewActions for Sliders. */
        object ViewActions

        /** Custom matchers for Sliders. */
        object Matchers
    }

    /** Contains custom matchers for Snackbars. */
    object Snackbars {
        object Matchers
    }

    /** Contains utilities for interacting with Switch components. */
    object Switches

    /** Contains helper functions for interacting with TextFields. */
    object TextFields {
        /** Custom ViewInteractions for TextFields. */
        object ViewInteractions
    }

    /** Contains general utility methods for interacting with Views. */
    object Views {
        /** Custom ViewInteractions for Views. */
        object ViewInteractions
    }

    /** Contains general utility methods for interacting with Views. */
    object Wait {
        /** Custom ViewInteractions for Views. */
        object ViewActions
    }
}

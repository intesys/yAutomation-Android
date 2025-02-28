package it.intesys.yautomation.uiTestHelpers.datePickers

import android.view.View
import android.widget.DatePicker
import androidx.test.espresso.matcher.BoundedMatcher
import it.intesys.yautomation.uiTestHelpers.YAutomation
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Matcher to check the year of a DatePicker.
 */
fun YAutomation.DatePickers.Matchers.hasDatePickerYear(year: Int): Matcher<View> = object : BoundedMatcher<View, DatePicker>(DatePicker::class.java) {
    override fun matchesSafely(view: DatePicker) = view.year == year
    override fun describeTo(description: Description) {
        description.appendText("with year: $year")
    }
}

/**
 * Matcher to check the month of a DatePicker.
 */
fun YAutomation.DatePickers.Matchers.hasDatePickerMonth(month: Int): Matcher<View> =
    object : BoundedMatcher<View, DatePicker>(DatePicker::class.java) {
        override fun matchesSafely(view: DatePicker) = view.month == month - 1 // DatePicker months are 0-based
        override fun describeTo(description: Description) {
            description.appendText("with month: $month")
    }
}

/**
 * Matcher to check the day of a DatePicker.
 */
fun YAutomation.DatePickers.Matchers.hasDatePickerDay(day: Int): Matcher<View> =
    object : BoundedMatcher<View, DatePicker>(DatePicker::class.java) {
        override fun matchesSafely(view: DatePicker) = view.dayOfMonth == day
        override fun describeTo(description: Description) {
            description.appendText("with day: $day")
        }
}
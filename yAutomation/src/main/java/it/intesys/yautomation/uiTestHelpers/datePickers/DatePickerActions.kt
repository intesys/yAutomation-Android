package it.intesys.yautomation.uiTestHelpers.datePickers

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions.setDate
import androidx.test.espresso.matcher.ViewMatchers.*
import it.intesys.yautomation.uiTestHelpers.YAutomation

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Sets the date in a DatePicker view using a view interaction.
 * @param viewInteraction The viewInteraction for the DatePicker view.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDate(viewInteraction: ViewInteraction, day: Int, month: Int, year: Int) {
    viewInteraction.perform(setDate(year, month, day))
}

/**
 * Sets the date in a DatePicker view using a matcher.
 * @param viewMatcher The matcher for the DatePicker view.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDate(viewMatcher: Matcher<View>, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.setDatePickerDate(onView(viewMatcher), day, month, year)
}

/**
 * Sets the date in a DatePicker view using a view ID.
 * @param viewId The resource ID of the DatePicker view.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDate(viewId: Int, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.setDatePickerDate(onView(withId(viewId)), day, month, year)
}

/**
 * Verifies the selected date in a DatePicker using a view interaction.
 * @param viewInteraction The viewInteraction for the DatePicker view.
 * @param day The expected day.
 * @param month The expected month.
 * @param year The expected year.
 */
fun YAutomation.DatePickers.checkDatePickerDate(viewInteraction: ViewInteraction, day: Int, month: Int, year: Int) {
    viewInteraction.check(
        matches(
            allOf(
                YAutomation.DatePickers.Matchers.hasDatePickerYear(year),
                YAutomation.DatePickers.Matchers.hasDatePickerMonth(month),
                YAutomation.DatePickers.Matchers.hasDatePickerDay(day)
            )
        )
    )
}

/**
 * Verifies the selected date in a DatePicker using a matcher.
 * @param viewMatcher The matcher for the DatePicker view.
 * @param day The expected day.
 * @param month The expected month.
 * @param year The expected year.
 */
fun YAutomation.DatePickers.checkDatePickerDate(viewMatcher: Matcher<View>, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.checkDatePickerDate(onView(viewMatcher), day, month, year)
}

/**
 * Verifies the selected date in a DatePicker using a view ID.
 * @param viewId The resource ID of the DatePicker view.
 * @param day The expected day.
 * @param month The expected month.
 * @param year The expected year.
 */
fun YAutomation.DatePickers.checkDatePickerDate(viewId: Int, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.checkDatePickerDate(onView(withId(viewId)), day, month, year)
}

/**
 * Selects a date in a DatePicker dialog using a view interaction.
 * @param viewInteraction The viewInteraction for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDialogDate(viewInteraction: ViewInteraction, day: Int, month: Int, year: Int) {
    viewInteraction.perform(click())
    YAutomation.DatePickers.ViewInteractions.datePickerView().perform(setDate(year, month, day))
    tapDatePickerOk()
}

/**
 * Selects a date in a DatePicker dialog using a matcher.
 * @param viewMatcher The matcher for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDialogDate(viewMatcher: Matcher<View>, day: Int, month: Int, year: Int) {
   YAutomation.DatePickers.setDatePickerDate(viewMatcher, day, month, year)
}

/**
 * Selects a date in a DatePicker dialog using a view ID.
 * @param viewId The resource ID of the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setDatePickerDialogDate(viewId: Int, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.setDatePickerDialogDate(onView(withId(viewId)), day, month, year)
}

/**
 * Selects a date in a Material DatePicker using a view interaction.
 * @param viewInteraction The viewInteraction for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setMaterialDatePickerDialogDate(viewInteraction: ViewInteraction, day: Int, month: Int, year: Int) {
    viewInteraction.perform(click())
    onView(withText(day.toString())).perform(click())
    onView(withText(month.toString())).perform(click())
    YAutomation.DatePickers.tapDatePickerOk()
}

/**
 * Selects a date in a Material DatePicker using a matcher.
 * @param viewMatcher The matcher for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setMaterialDatePickerDialogDate(viewMatcher: Matcher<View>, day: Int, month: Int, year: Int) {
   YAutomation.DatePickers.setMaterialDatePickerDialogDate(onView(viewMatcher), day, month, year)
}

/**
 * Selects a date in a Material DatePicker using a view ID.
 * @param viewId The resource ID of the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.setMaterialDatePickerDialogDate(viewId: Int, day: Int, month: Int, year: Int) {
    setMaterialDatePickerDialogDate(onView(withId(viewId)), day, month, year)
}

/**
 * Selects a date in a Material DatePicker using a view interaction.
 * @param viewInteraction The viewInteraction for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.selectDateInMaterialDatePicker(viewInteraction: ViewInteraction, day: Int, month: Int, year: Int) {
    viewInteraction.perform(click())

    YAutomation.DatePickers.ViewInteractions.materialDatePickerHeaderView()
        .perform(click())

    YAutomation.DatePickers.ViewInteractions.datePickerTextInput()
        .perform(typeText(YAutomation.DatePickers.Utilities.formatDate(day, month, year)), closeSoftKeyboard())

    onView(withId(com.google.android.material.R.id.confirm_button))
        .perform(click())
}

/**
 * Selects a date in a Material DatePicker using a matcher.
 * @param viewMatcher The matcher for the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.selectDateInMaterialDatePicker(viewMatcher: Matcher<View>, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.selectDateInMaterialDatePicker(onView(viewMatcher), day, month, year)
}

/**
 * Selects a date in a Material DatePicker using a view ID.
 * @param viewId The resource ID of the DatePicker trigger.
 * @param day The day to set.
 * @param month The month to set.
 * @param year The year to set.
 */
fun YAutomation.DatePickers.selectDateInMaterialDatePicker(viewId: Int, day: Int, month: Int, year: Int) {
    YAutomation.DatePickers.selectDateInMaterialDatePicker(withId(viewId), day, month, year)
}

/**
 * Taps the "OK" button in a DatePicker dialog.
 */
fun YAutomation.DatePickers.tapDatePickerOk() {
    YAutomation.DatePickers.ViewInteractions.datePickerOkButton().perform(click())
}





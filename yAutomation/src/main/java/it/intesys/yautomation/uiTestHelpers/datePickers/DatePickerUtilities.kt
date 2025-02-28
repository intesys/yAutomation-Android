package it.intesys.yautomation.uiTestHelpers.datePickers

import it.intesys.yautomation.uiTestHelpers.YAutomation
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Calendar.getInstance
import java.util.Locale

/**
 * Formats a date in a human-readable format.
 * @param day The day.
 * @param month The month.
 * @param year The year.
 * @return The formatted date string.
 */
fun YAutomation.DatePickers.Utilities.formatDate(day: Int, month: Int, year: Int): String {
    val calendar = getInstance().apply {
        set(Calendar.DAY_OF_MONTH, day)
        set(Calendar.MONTH, month - 1) // Calendar.MONTH is 0-based
        set(Calendar.YEAR, year)
    }
    return SimpleDateFormat("E, MM dd, yyyy", Locale.getDefault()).format(calendar.time)
}
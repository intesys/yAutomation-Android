package it.intesys.yautomation.uiTestHelpers.datePickers

import android.widget.DatePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import it.intesys.yautomation.uiTestHelpers.textfields.onTextfieldView
import org.hamcrest.Matchers.equalTo

/**
 * Returns a ViewInteraction for the DatePicker view.
 * @return ViewInteraction targeting the DatePicker.
 */
fun YAutomation.DatePickers.ViewInteractions.datePickerView(): ViewInteraction {
    return onView(withClassName(equalTo(DatePicker::class.java.name)))
}

/**
 * Returns a ViewInteraction for the Material DatePicker header toggle view.
 * @return ViewInteraction targeting the Material DatePicker header toggle.
 */
fun YAutomation.DatePickers.ViewInteractions.materialDatePickerHeaderView(): ViewInteraction {
    return onView(withId(com.google.android.material.R.id.mtrl_picker_header_toggle))
}

/**
 * Returns a ViewInteraction for the Material DatePicker text input field.
 * @return ViewInteraction targeting the text input field for the Material DatePicker.
 */
fun YAutomation.DatePickers.ViewInteractions.datePickerTextInput(): ViewInteraction {
    return YAutomation.TextFields.ViewInteractions.onTextfieldView(withId(com.google.android.material.R.id.mtrl_picker_text_input_date))
}

/**
 * Returns a ViewInteraction for the DatePicker OK button.
 * @return ViewInteraction targeting the OK button in a DatePicker dialog.
 */
fun YAutomation.DatePickers.ViewInteractions.datePickerOkButton(): ViewInteraction {
    return onView(withId(android.R.id.button1))
}

package it.intesys.ybddtests.test

import android.content.Intent
import androidx.core.content.ContextCompat.getString
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import it.intesys.yautomation.uiTestHelpers.YAutomation
import it.intesys.yautomation.uiTestHelpers.datePickers.checkDatePickerDate
import it.intesys.yautomation.uiTestHelpers.datePickers.selectDateInMaterialDatePicker
import it.intesys.yautomation.uiTestHelpers.datePickers.setDatePickerDate
import it.intesys.yautomation.uiTestHelpers.imageViews.hasImages
import it.intesys.yautomation.uiTestHelpers.menus.openKebabMenu
import it.intesys.yautomation.uiTestHelpers.pickers.checkNumberPickerSelectedValueIs
import it.intesys.yautomation.uiTestHelpers.pickers.checkSpinnerSelectedValue
import it.intesys.yautomation.uiTestHelpers.pickers.setNumberPickerDisplayValue
import it.intesys.yautomation.uiTestHelpers.pickers.setSpinnerSelectedValue
import it.intesys.yautomation.uiTestHelpers.recyclerViews.allItemsContainTextInView
import it.intesys.yautomation.uiTestHelpers.recyclerViews.itemWithTextIsSelected
import it.intesys.yautomation.uiTestHelpers.recyclerViews.scrollToItemContainingText
import it.intesys.yautomation.uiTestHelpers.recyclerViews.scrollToPosition
import it.intesys.yautomation.uiTestHelpers.recyclerViews.tapFromList
import it.intesys.yautomation.uiTestHelpers.searchbar.typeInSearchBar
import it.intesys.yautomation.uiTestHelpers.sliders.setSliderValue
import it.intesys.yautomation.uiTestHelpers.snackbars.waitUntilSnackbarAppears
import it.intesys.yautomation.uiTestHelpers.switches.switchIs
import it.intesys.yautomation.uiTestHelpers.textfields.typeOnEditText
import it.intesys.yautomation.uiTestHelpers.views.tap
import it.intesys.yautomation.uiTestHelpers.wait.waitUntilTextAppear
import it.intesys.yautomation.uiTestHelpers.wait.waitUntilViewIsVisible
import it.intesys.ybddtests.MainActivity
import it.intesys.ybddtests.R.id
import it.intesys.ybddtests.R.string
import org.junit.Rule
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class BddTests {
    @JvmField
    @Rule
    var activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule
    lateinit var activity: MainActivity

    @Before()
    fun setup() {
        activityTestRule.launchActivity(Intent())
        activity = activityTestRule.activity
        YAutomation.changeAnimationStatus(false)
    }

    @After()
    fun finish() {
        YAutomation.changeAnimationStatus(true)
        activityTestRule.finishActivity()
    }

    fun waitOnFinish() { //Just to show better what happens
        Thread.sleep(2000)
    }

    @Given("^I am in demo")
    fun i_am_in_demo() {
        YAutomation.Wait.waitUntilViewIsVisible(id.demo)
    }

    @Given("^I am in form")
    fun i_am_in_form() {
        YAutomation.Wait.waitUntilViewIsVisible(id.form)
    }

    @When("^I tap on form")
    fun i_tap_on_form() {
        YAutomation.Views.tap(id.form_button)
    }

    @Given("^I am in list")
    fun i_am_in_list() {
        YAutomation.Wait.waitUntilViewIsVisible(id.list)
    }

    @When("^I tap on list")
    fun i_tap_on_list() {
        YAutomation.Views.tap(id.list_button)
    }

    @Given("^I am in images")
    fun i_am_in_images() {
        YAutomation.Wait.waitUntilViewIsVisible(id.images)
    }

    @When("^I tap on images")
    fun i_tap_on_images() {
        YAutomation.Views.tap(id.images_button)
    }

    @Given("^I am in controls")
    fun i_am_in_controls() {
        YAutomation.Wait.waitUntilViewIsVisible(id.controls)
    }

    @When("^I tap on controls")
    fun i_tap_on_controls() {
        YAutomation.Views.tap(id.controls_button)
    }

    @Given("^I am in pickers")
    fun i_am_in_pickers() {
        YAutomation.Wait.waitUntilViewIsVisible(id.pickers)
    }

    @When("^I tap on pickers")
    fun i_tap_on_pickers() {
        YAutomation.Views.tap(id.picker_button)
    }

    @Given("^I am in date pickers")
    fun i_am_in_date_pickers() {
        YAutomation.Wait.waitUntilViewIsVisible(id.date_pickers)
    }

    @When("^I tap on date pickers")
    fun i_tap_on_date_pickers() {
        YAutomation.Views.tap(id.date_picker_button)
    }

    @Given("^I am in alerts")
    fun i_am_in_alerts() {
        YAutomation.Wait.waitUntilViewIsVisible(id.alerts)
    }

    @When("^I tap on alerts")
    fun i_tap_on_alerts() {
        YAutomation.Views.tap(id.alerts_button)
    }

    @Given("^I am in \"([^\"]*)\"$")
    fun i_am_in(sectionButton: String) {
        when (sectionButton) {
            "form" -> YAutomation.Wait.waitUntilViewIsVisible(id.form)
            "list" -> YAutomation.Wait.waitUntilViewIsVisible(id.list)
            "images" -> YAutomation.Wait.waitUntilViewIsVisible(id.images)
            "controls" -> YAutomation.Wait.waitUntilViewIsVisible(id.controls)
            "pickers" -> YAutomation.Wait.waitUntilViewIsVisible(id.pickers)
            "date pickers" -> YAutomation.Wait.waitUntilViewIsVisible(id.date_pickers)
            "alerts" -> YAutomation.Wait.waitUntilViewIsVisible(id.alerts)
        }
    }

    @When("^I tap on \"([^\"]*)\"$")
    fun i_tap_on(section: String) {
        YAutomation.Views.tap(
            when (section) {
                "form" -> id.form_button
                "list" -> id.list_button
                "images" -> id.images_button
                "controls" -> id.controls_button
                "pickers" -> id.picker_button
                "date pickers" -> id.date_picker_button
                "alerts" -> id.alerts_button
                else -> -1
            })
    }

    @Given("^I am in info")
    fun i_am_in_info() {
        YAutomation.Wait.waitUntilViewIsVisible(id.info_view)
    }

    @When("^I tap on info")
    fun i_tap_on_info() {
        YAutomation.Views.tap(id.info)
    }

    @Given("^I am in credits")
    fun i_am_in_credits() {
        YAutomation.Wait.waitUntilViewIsVisible(id.credits_view)
    }

    @When("^I tap on credits")
    fun i_tap_on_credits() {
        YAutomation.Views.tap(id.credits)
    }

    @When("^I tap on home")
    fun i_tap_on_home() {
        YAutomation.Views.tap(id.home)
    }

    @Then("Bottom bar home is visible")
    fun bottom_bar_home_is_visible() {
        YAutomation.Wait.waitUntilViewIsVisible(id.home)
    }

    @Then("Bottom bar info is visible")
    fun bottom_bar_info_is_visible() {
        YAutomation.Wait.waitUntilViewIsVisible(id.info)
    }

    @Then("Bottom bar credits is visible")
    fun bottom_bar_credits_is_visible() {
        YAutomation.Wait.waitUntilViewIsVisible(id.credits)
    }

    @Then("Title Demo BDD is visible")
    fun demo_bdd_is_visible() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.demoName))
    }

    @Then("Text containg Demo is visible")
    fun demo_is_visible() {
        YAutomation.Wait.waitUntilTextAppear("Demo", exactMatch = false)
    }

    @Then("There are 2 images")
    fun has_2_images() {
        YAutomation.ImageViews.hasImages(id.images,2)
    }

    @Then("There is at least 1 image")
    fun has_at_least_1_images() {
        YAutomation.ImageViews.hasImages(id.images,1, orMore = true)
    }

    @When("^I tap on an item in the list")
    fun i_tap_on_an_item_in_the_list() {
        val unicornText = "🦄"
        YAutomation.RecyclerViews.tapFromList(id.listRecyclerView, unicornText)
    }

    @Then("The item tapped is selected")
    fun the_item_tapped_is_selected() {
        val unicornText = "🦄"
        YAutomation.RecyclerViews.itemWithTextIsSelected(id.checked, unicornText)
        waitOnFinish()
    }

    @When("^I tap on an item in the bottom")
    fun i_tap_on_an_item_in_the_bottom() {
        YAutomation.RecyclerViews.scrollToItemContainingText(id.listRecyclerView, "🐔")
        waitOnFinish()
    }

    @When("^I scroll to top")
    fun i_scroll_to_top() {
        YAutomation.RecyclerViews.scrollToPosition(id.listRecyclerView, 0)
    }

    @Then("The first item is displayed")
    fun the_first_item_is_displayed() {
        YAutomation.Wait.waitUntilTextAppear("🐶🐱")
        waitOnFinish()
    }

    @When("^I tap on kebab menu")
    fun i_tap_on_kebab_menu() {
        YAutomation.openKebabMenu()
    }

    @When("^I tap on item 1")
    fun i_tap_on_item_1() {
        YAutomation.Views.tap(getString(activity, string.item1))
    }

    @Then("Snackbar with item 1 appear")
    fun snackbar_with_item_1_appear() {
        YAutomation.Snackbars.waitUntilSnackbarAppears("Item 1")
        waitOnFinish()
    }

    @When("^I tap on item 2")
    fun i_tap_on_item_2() {
        YAutomation.Views.tap(getString(activity, string.item2))
    }

    @Then("Snackbar with item 2 appear")
    fun snackbar_with_item_2_appear() {
        YAutomation.Snackbars.waitUntilSnackbarAppears("Item 2")
        waitOnFinish()
    }

    @When("^I tap on item 3")
    fun i_tap_on_item_3() {
        YAutomation.Views.tap(getString(activity, string.item3))
    }

    @Then("Snackbar with item 3 appear")
    fun snackbar_with_item_3_appear() {
        YAutomation.Snackbars.waitUntilSnackbarAppears("Item 3")
        waitOnFinish()
    }

    @When("^I write a text in the searchbar")
    fun i_write_a_text_in_the_searchbar() {
        YAutomation.SearchBar.typeInSearchBar(id.searchView, "🦊")
    }

    @Then("All items contain the text")
    fun all_items_contain_the_text() {
        YAutomation.RecyclerViews.allItemsContainTextInView(id.listRecyclerView, id.list_item_text, "🦊")
        waitOnFinish()
    }

    @When("^I input firstname")
    fun i_input_firstname() {
        YAutomation.TextFields.typeOnEditText(id.inputName, "Marvin")
    }

    @When("^I input lastname")
    fun i_input_lastname() {
        YAutomation.TextFields.typeOnEditText(id.inputSurname, "Pantalozzi")
    }

    @When("^I input phone number")
    fun i_input_phone_number() {
        YAutomation.TextFields.typeOnEditText(id.inputPhoneNumber, "3456789")
    }
    @When("^I tap on save button")
    fun i_tap_on_save_button() {
        YAutomation.Views.tap(id.send)
    }
    @Then("A loading appear")
    fun a_loading_appear() {
        YAutomation.Wait.waitUntilViewIsVisible(id.loader)
    }

    @Then("A dialog with title Alert Title appear")
    fun a_dialog_with_title_alert_title_appear() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.alertTitle))
        waitOnFinish()
    }

    @When("switch is off")
    fun switch_is_off() {
        YAutomation.Switches.switchIs(id.is_active_switch, false)
    }

    @When("I tap on the switch")
    fun i_tap_on_the_switch() {
        YAutomation.Views.tap(id.is_active_switch)
    }

    @When("switch is on")
    fun switch_is_on() {
        YAutomation.Switches.switchIs(id.is_active_switch, true)
        waitOnFinish()
    }

    @When("I move slider to 50")
    fun i_move_slider_to_50() {
        YAutomation.Sliders.setSliderValue(id.slider, 50f)
    }

    @Then("The shown value is 50")
    fun the_shown_value_is_50() {
        YAutomation.Wait.waitUntilTextAppear("50.0")
        waitOnFinish()
    }

    @When("I set spinner to blue")
    fun i_set_spinner_to_blue() {
        YAutomation.Pickers.setSpinnerSelectedValue(id.spinner, "Blue")
    }

    @Then("number picker value is blue")
    fun number_picker_value_is_blue() {
        YAutomation.Pickers.checkNumberPickerSelectedValueIs(id.number_picker,"Blue")
    }

    @Then("you selected field is blue")
    fun you_selected_field_is_blue() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.selected_color, "Blue"))
        waitOnFinish()
    }

    @When("I set number picker to blue")
    fun i_set_number_picker_to_blue() {
        YAutomation.Pickers.setNumberPickerDisplayValue(id.number_picker, "Blue")
        waitOnFinish()
    }

    @Then("spinner value is blue")
    fun spinner_value_is_blue() {
        YAutomation.Pickers.checkSpinnerSelectedValue(id.spinner, "Blue")
    }

    @When("I set datePicker to 18 January 2024")
    fun i_set_date_picker_to_18_january_2024() {
        YAutomation.DatePickers.setDatePickerDate(id.datePicker, 18, 1, 2024)
    }

    @Then("button date picker value is 18 January 2024")
    fun button_date_picker_value_is_18_january_2024() {
        YAutomation.Wait.waitUntilTextAppear("18/01/2024")
    }

    @Then("date picker value is 18 January 2024")
    fun date_picker_value_is_18_january_2024() {
        YAutomation.DatePickers.checkDatePickerDate(id.datePicker, 18, 1, 2024)
    }

    @Then("date is field date is 18 January 2024")
    fun date_is_field_date_is_18_january_2024() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.date_is, "18/01/2024"))
        waitOnFinish()
    }

    @When("I set date picker dialog to 18 January 2024")
    fun i_set_date_picker_dialog_to_18_january_2024() {
        YAutomation.DatePickers.selectDateInMaterialDatePicker(id.date_picker_button, 18, 1, 2024)
    }

    @When("I tap on Show Yes/No alert")
    fun i_tap_on_show_yes_no_alert() {
        YAutomation.Views.tap(id.yes_no_button)
    }

    @When("button yes and no appear")
    fun button_yes_and_no_appear() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.yes))
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.no))
    }

    @When("I tap on yes")
    fun i_tap_on_yes() {
        YAutomation.Views.tap(activity.getString(string.yes))
    }

    @When("I tap on no")
    fun i_tap_on_no() {
        YAutomation.Views.tap(activity.getString(string.no))
    }

    @Then("yes tapped text appears")
    fun yes_tapped_text_appears() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.yes_tapped))
    }

    @Then("no tapped text appears")
    fun no_tapped_text_appears() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.no_tapped))
    }

    @When("I tap on Show color options")
    fun i_tap_on_show_color_options() {
        YAutomation.Views.tap(id.colors_button)
    }

    @Then("options green, red and yellow  appear")
    fun options_green_red_and_yellow_appear() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.green))
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.red))
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.yellow))
    }

    @When("I tap on green")
    fun i_tap_on_green() {
        YAutomation.Views.tap(activity.getString(string.green))
    }

    @Then("green tapped text appears")
    fun green_tapped_text_appears() {
        YAutomation.Wait.waitUntilTextAppear(activity.getString(string.tapped, "Green"))
    }

}
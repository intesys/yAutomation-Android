
# yAutomation

`yAutomation` is a simple library to make it easier to implement UI Tests.

The library implements a `YAutomation` static object that can be used to simplify the most common UI interactions using Espresso.

We developed `yAutomation` to make it simpler to write UI tests based on BDD with Gherkin. For this reason, the demo project includes all the tests, for all components, in Gherkin using `yAutomation` and [`cucumber-android`](https://github.com/cucumber/cucumber-android) together.

## Usage

### Animations

To improve the speed and reliability of your UI tests, you may want to disable system animations during test execution. Animations can cause flickering or delays that lead to flaky tests.

To disable animations, call the following function before running your tests:

```kotlin
YAutomation.changeAnimationStatus(false)
```

This will disable animations during test execution. You can re-enable animations once the test is finished:

```kotlin
YAutomation.changeAnimationStatus(true)
```

This is particularly useful for ensuring consistent behavior across devices with varying animation speeds. It is recommended to disable animations for tests where timing and precision are critical, and then re-enable them after the test to restore the device's default behavior.

### Wait for UI Updates

In UI testing, it is essential to ensure that elements are ready before interacting with them. `yAutomation` provides simple commands for waiting until a view is visible or a specific text appears.

#### Wait for Text to Appear

```kotlin
YAutomation.Wait.waitUntilTextAppear("Text to appear")
```

This command waits for the specified text to appear on the screen. It internally polls the UI at regular intervals until the text is found or the timeout is reached. This helps ensure that your tests wait for the necessary UI updates before continuing.

#### Wait for View to Become Visible

```kotlin
YAutomation.Wait.waitUntilViewIsVisible(id.viewId)
```

This command waits for the specified view to become visible. It checks the visibility of the view at regular intervals, helping to avoid errors caused by trying to interact with invisible elements. The polling interval and timeout are configurable within the library.

#### Wait for View to set Visibility to Gone

```kotlin
YAutomation.Wait.waitUntilViewIsGone(id.viewId)
```

This command waits for the specified view visibility changes to GONE. It checks the visibility of the view at regular intervals, helping to avoid errors caused by trying to interact with invisible elements. The polling interval and timeout are configurable within the library.

### UI Helper Functions

Here are some examples of useful helper functions for common UI interactions:

1. **Tap on a View**:
   ```kotlin
   YAutomation.Views.tap(id.viewId)
   ```
   Taps on the specified view.

2. **Set Slider Value**:
   ```kotlin
   YAutomation.Sliders.setSliderValue(id.slider, 50f)
   ```
   Sets the slider to the specified value.

3. **Check if a View is Visible**:
   ```kotlin
   YAutomation.Views.isVisible(id.viewId)
   ```
   Asserts that a view is visible on the screen.

4. **Tap on an Item in a RecyclerView**:
   ```kotlin
   YAutomation.RecyclerViews.tapFromList(id.recyclerView, "Item Text")
   ```
   Taps on an item in a RecyclerView based on the item’s text.

5. **Check Snackbar Message**:
   ```kotlin
   YAutomation.Snackbars.waitUntilSnackbarAppears("Snackbar Text")
   ```
   Waits for a Snackbar with the specified text to appear.

6. **Check if Text is Displayed**:
   ```kotlin
   YAutomation.Wait.waitUntilTextAppear("Expected Text")
   ```
   Waits until the specified text is displayed on the screen.

7. **Set a Switch to On/Off**:
   ```kotlin
   YAutomation.Switches.toggle(id.switchView, true)
   ```
   Toggles a switch to the specified state (on/off).

8. **Swipe RecyclerView Item**:
   ```kotlin
   YAutomation.RecyclerViews.swipeItem(id.recyclerView, "Item Text")
   ```
   Swipes an item in a RecyclerView based on the item's text.


### Demo Project

The demo project implements different sections with the most common UI components as a playground to perform various types of tests and show the usage of the library in a real project. The sections include components like buttons, text fields, sliders, recyclers, date pickers, and more. The project aims to demonstrate how the `yAutomation` library simplifies the process of automating UI tests and integrates smoothly with Android's Espresso framework.

### Gherkin

The demo project uses Gherkin to implement all the UI tests. While it is not mandatory to use Gherkin and BDD (Behavior-Driven Development), it is our main use case, and thus, we chose this approach for the demo project. Using Gherkin allows the tests to be written in a human-readable format, making it easier for non-developers to understand the test scenarios and expected outcomes.

This approach can be helpful for teams that collaborate closely with product owners, QA testers, or other non-developers who can easily understand the Gherkin syntax.

### Notes

[`cucumber-android`](https://github.com/cucumber/cucumber-android) library is used in the demo project only to provide a sample. 
Copyright (c) The Cucumber Organisation under MIT License


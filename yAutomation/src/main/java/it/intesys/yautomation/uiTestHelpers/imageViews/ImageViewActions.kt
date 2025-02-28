package it.intesys.yautomation.uiTestHelpers.imageViews

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import it.intesys.yautomation.uiTestHelpers.YAutomation
import it.intesys.yautomation.uiTestHelpers.views.hasViewWithClass
import org.hamcrest.Matcher

/**
 * Checks if an ImageView contains the expected number of images.
 * @param viewInteraction ViewInteraction for identifying the parent view.
 * @param count The expected number of images.
 * @param orMore If true, checks if there are at least the given number of images.
 */
fun YAutomation.ImageViews.hasImages(viewInteraction: ViewInteraction, count: Int, orMore: Boolean = false) {
    YAutomation.hasViewWithClass(viewInteraction, ImageView::class.java, count, orMore)
}

/**
 * Checks if an ImageView contains the expected number of images.
 * @param viewMatcher Matcher for identifying the parent view.
 * @param count The expected number of images.
 * @param orMore If true, checks if there are at least the given number of images.
 */
fun YAutomation.ImageViews.hasImages(viewMatcher: Matcher<View>, count: Int, orMore: Boolean = false) {
    YAutomation.ImageViews.hasImages(onView(viewMatcher), count, orMore)
}

/**
 * Checks if an ImageView contains the expected number of images by view ID.
 * @param viewId The resource ID of the parent view.
 * @param count The expected number of images.
 * @param orMore If true, checks if there are at least the given number of images.
 */
fun YAutomation.ImageViews.hasImages(viewId: Int, count: Int, orMore: Boolean = false) {
    hasImages(withId(viewId), count, orMore)
}


//TODO: This needs more actions for images like

package me.hrant.androidcilab

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import me.hrant.androidcilab.ui.theme.AndroidCILabTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainScreen_displaysTitle() {
        composeTestRule.setContent {
            AndroidCILabTheme {
                MainScreen()
            }
        }
        composeTestRule.onNodeWithText("Android CI Lab").assertIsDisplayed()
    }
}

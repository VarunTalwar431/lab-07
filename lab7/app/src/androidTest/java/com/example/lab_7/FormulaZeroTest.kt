package com.example.lab_7

//import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

        //Verify that you can properly go from the HomeScreen to the DriversScreen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        //enter driver
        composeTestRule
            .onNodeWithTag("DriverInput")
            .performTextInput("Lewis Hamilton")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        //make sure driver appears on screen
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        //enter driver
        composeTestRule
            .onNodeWithTag("DriverInput")
            .performTextInput("Max Verstappen")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        //make sure driver appears on screen
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        //Verify that you can properly clear the driver(s) from the list
        composeTestRule
            .onNodeWithTag("ClearDriver")
            .performClick()

        //Verify that the back button takes you back to the HomeScreen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

    }
}
package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCalendarEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinition {
    CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();


    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        createCalendarEventPage.clickOnCreateCalendarEvent();
    }

    /*
    |Title             |B20 Graduation Party                       |
    |Description       |All B20 friends are invited for this party!|
     */
    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String, String> data) {
        String title = data.get("Title");
        String describtion = data.get("Description");

        createCalendarEventPage.enterDescription(describtion);
        createCalendarEventPage.enterTitle(title);

    }

    @Then("user verifies that the calendar event is displayed")
    public void user_verifies_that_the_calendar_event_is_displayed(Map<String, String> data) {
        String title = data.get("Title");
        String description = data.get("Description");

        Assert.assertEquals(title, createCalendarEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description,createCalendarEventPage.getDataFromGeneralInfo("Description"));
    }
}

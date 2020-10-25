package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import sun.jvm.hotspot.debugger.Page;

public class CommonStepDefinition {

    //LoginPage loginPage = new LoginPage();
    BasePage basePage = new LoginPage();

    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        basePage.navigateTo(string, string2);
    }
    @When("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        basePage.clickSaveAndClose();
    }

}

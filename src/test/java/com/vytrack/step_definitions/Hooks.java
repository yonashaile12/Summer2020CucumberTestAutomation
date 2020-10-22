package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

/**
 * Hooks name is not reserved. you may name this class in any way.
 * For example: SuitSetUpAndTestDown.
 * Hooks triggered based on tags not class name or their location.
 * These methods can be part of any step definition class.
 * Common practice is to store them in the separate class.
 */


public class Hooks {

//   hook before == @BeforeMethod in TestNG
//   Hook after == @AfterMethod in TestNG
//   it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//   usually, we just use explicit and fluent waits

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation :::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //this hook will run only before scenarios with a tag @db

    /**
     * Scenario: I don't know but here I'm connecting to DB
     * Given nuser runs following query "SELECT *..."
     *
     * order = 0-to define hooks
     */
    @Before(value = "@db", order = 0)
    public void dbSetup(){
        System.out.println("::: Connecting to database :::");
    }

    @After("db")
    public void dbTearDown(){
        System.out.println("::: Disconnecting from the database :::");
    }

    @After
    public void teardown(){
        //close browser, close DB connection, close tunnel, take a screen shot
        // this is a hook after
        // runs automatically after every test
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*) :::");
    }

}

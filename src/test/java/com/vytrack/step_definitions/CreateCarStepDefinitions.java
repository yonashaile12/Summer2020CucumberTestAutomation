package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {
    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        createCarPage.clickOnCreateCar();
    }

    /**
     * When user adds new vehicle information
     * | License Plate | SDET |
     * | Model Year    | 2021 |
     * key           value
     * <p>
     * dataTable.get("License Plate") --> SDET
     * dataTable.get("Model Year")    --> 2021
     * <p>
     * map it's data structure where every value is referenced by key
     * <p>
     * (in arraylist it's always index)
     * dataTable = { License Plate = SDET,
     * Model Year = 2021 }
     * <p>
     * If you want to turn data table into map, it must be exactly 2 columns
     * <p>
     * If it's a 1 column, it can be just List:
     * <p>
     * Then user verifies following list:
     * |10|
     * |20|
     * |50|
     *
     * @Then("user verifies following list:")
     * public void user_verifies_following_list(List<String> dataTable){}
     * <p>
     * DataTable - cucumber data structure/data type. We convert it into Map, List or List<Map<>>
     */
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        //to get all keys and values one by one
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

//        for(Map.Entry<String, String> entry: dataTable.entrySet()){
//            System.out.println("Key: " + entry.getKey() + ", value: "+entry.getValue());
//        }

        String licensePlate = dataTable.get("License Plate");
        String modelYear = dataTable.get("Model Year");

        System.out.println("License plate: " + licensePlate);
        System.out.println("Model year: " + modelYear);

        createCarPage.enterLicensePlate(licensePlate);
        createCarPage.enterModelYear(modelYear);
    }
}

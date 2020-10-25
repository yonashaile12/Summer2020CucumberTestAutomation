package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage{

    @FindBy(css ="[title='Create Car']")
    private WebElement createCatBtn;

    public void clickOnCreateCar(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(createCatBtn)).click();
        System.out.println("Clicking on Create car button");
    }
}

package com.vytrack.pages;

import com.vytrack.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //to not use webElements directly in step definition classes
    //helps to prevent code duplication and keep step definitions classes
    @FindBy(id ="prependedInput")
    private WebElement username;

    @FindBy(id ="prependedInput2")
    private WebElement password;

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("storemanager.username");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String role){
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if(role.equalsIgnoreCase("sales manager")){
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        }else if(role.equalsIgnoreCase("driver")){
            usernameValue = ConfigurationReader.getProperty("driver.username");
        }else{
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }



}

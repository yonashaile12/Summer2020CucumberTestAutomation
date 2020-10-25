package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    @FindBy(className ="oro-subtitle")
    protected WebElement pageSubTitle;

    @FindBy(xpath = "(//button[contains(text(),'Save and Close')])[1]")
    protected WebElement saveAndcloseBtn;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getPageSubTitleText(){
        return pageSubTitle.getText();
    }

    /**
     * method for navigation in Vytrack app
     * @param tab , for example: Feelt, DashBoard, Sales, Activities...
     * @param module, one of the value that will be visible after clicking on the tab
     */
    public void navigateTo(String tab, String module){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        String tabXpath = "//*[contains(text(),'" + tab + "') and @class='title title-level-1']";
        String moduleXpath = "//*[contains(text(),'"+module+"') and @class='title title-level-2']";

        //wait for presence and ability co click on element
        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();
    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndcloseBtn);
    }

}

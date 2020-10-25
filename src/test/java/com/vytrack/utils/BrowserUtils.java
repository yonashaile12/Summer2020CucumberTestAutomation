package com.vytrack.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    public void wait(int seconds){
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()",element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value",text));
        System.out.println("Entering text: "+text);
    }

    /**
     * For instance, Selenium WebDriver is trying to enter the text:
     * Expected text input actual text input
     *
     * [java is great] --> [java is g] jumps to the next step without finishing text input here
     *
     * for some reason, selenium jumps to the next step without finishing text input
     *
     * to prevent this issue, we need to make it wait until text is completely enetered
     *
     * how to do that?
     *
     * As we know, text is stored in the value attribute. So we need to wait until value attribute
     * of the element will obtain expected text.
     */


}

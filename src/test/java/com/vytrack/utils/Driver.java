package com.vytrack.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    Driver.getDriver().manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    Driver.getDriver().manage().window().maximize();
                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

    public static void pageLoadTimeout() {
        Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public static void implicitlyWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}

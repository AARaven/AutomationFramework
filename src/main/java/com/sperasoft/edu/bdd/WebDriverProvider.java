package com.sperasoft.edu.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    private final WebDriver driver;

    public WebDriverProvider() {
        System.setProperty( "webdriver.chrome.driver" ,
                            "./src/test/resources/webdrivers/chromedriver.exe" );
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Before
    public WebDriver getDriver() {
        return this.driver;
    }

    @After
    public void closeSession() {
        this.driver.close();
        this.driver.quit();
    }
}

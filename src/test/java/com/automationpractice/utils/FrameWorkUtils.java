package com.automationpractice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FrameWorkUtils {
    
    
    /**
     * Method that implementing finding the WebElement, those displayed in the page,
     * from list of WebElements and click on it
     *
     * @param webElements {@code List<WebElement>} for searching
     */
    public static WebElement findElementFromList( List < WebElement > webElements ) {
        return webElements.stream()
                          .filter( WebElement :: isDisplayed )
                          .findAny()
                          .orElse( null );
    }
    
    /**
     * @param driver     thread-safe instance of {@code WebDriver}
     * @param webElement {@code WebElement} for click on it
     */
    public static void clickWhenClickable( WebDriver driver, WebElement webElement ) {
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        wait.until( ExpectedConditions.elementToBeClickable( webElement ) ).click();
    }
}

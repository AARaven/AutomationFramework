package com.automationpractice.utils;

import com.automationpractice.site.conditions.AdditionalConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.Arrays;
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
                          .findFirst()
                          .orElse( null );
    }

    /**
     * @param driver     thread-safe instance of {@code WebDriver}
     * @param webElement {@code WebElement} for click on it
     */
    public static void clickWhenClickable( WebDriver driver , WebElement webElement ) {
        WebDriverWait wait = new WebDriverWait( driver , 5 , 100 );
        wait.until( ExpectedConditions.and( ExpectedConditions.visibilityOf( webElement ) ,
                                            ExpectedConditions.elementToBeClickable( webElement ),
                                            AdditionalConditions.jQueryAJAXCallsHaveCompleted() ) );
        webElement.click();
    }
}

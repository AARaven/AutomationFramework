package com.automationpractice.Utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FrameWorkUtils {
    
    public static void clickElementFromList( List < WebElement > webElements ) {
        
        webElements.stream()
                   .filter( WebElement :: isDisplayed )
                   .findAny()
                   .ifPresent( WebElement :: click );
    }
    
}

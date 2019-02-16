package com.automationpractice.site.conditions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Objects;

public class AdditionalConditions {
    
    public static ExpectedCondition < Boolean > jQueryAJAXCallsHaveCompleted() {
        return webDriver -> ( Boolean ) ( ( JavascriptExecutor ) Objects.requireNonNull( webDriver ) )
                .executeScript( "return jQuery.active === 0;" );
    }
    
    //"return (window.JQuery != null) && (JQuery.active === 0);"
    
    public static ExpectedCondition < Boolean > angularHasFinishedProcessing() {
        return webDriver -> ( Boolean ) (
                ( ( JavascriptExecutor ) Objects.requireNonNull( webDriver ) )
                        .executeScript(
                                "return (window.angular !== undefined) " +
                                "&& (angular.element(document).injector()" +
                                ".get('$http').pendingRequest.length === 0)" ) );
    }
}

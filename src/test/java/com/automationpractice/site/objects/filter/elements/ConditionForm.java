package com.automationpractice.site.objects.filter.elements;

import models.order.enums.Conditions;
import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class ConditionForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_condition_new']" ) private WebElement checkboxNew;
    
    public ConditionForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxNew() {
        getCheckboxNew().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Conditions conditions ) {
        switch ( conditions ) {
            case DEFAULT:
                break;
            case NEW:
                getCheckboxNew()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
package com.automationpractice.Forms.FilterForms;

import Models.Order.Clothes.Enums.ForUserChoice.Conditions;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class ConditionForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_condition_new']" ) private WebElement checkboxNew;
    
    ConditionForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxNew() {
        this.getCheckboxNew().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Conditions conditions ) {
        switch ( conditions ) {
            case DEFAULT:
                break;
            case NEW:
                this.getCheckboxNew().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

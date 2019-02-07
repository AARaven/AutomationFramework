package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Sizes;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class SizeForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_id_attribute_group_1']" ) private WebElement checkboxSmall;
    @FindBy( css = "input[id='layered_id_attribute_group_2']" ) private WebElement checkboxMedium;
    @FindBy( css = "input[id='layered_id_attribute_group_3']" ) private WebElement checkboxLarge;
    
    SizeForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxSmall() {
        this.getCheckboxSmall().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxMedium() {
        this.getCheckboxMedium().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxLarge() {
        this.getCheckboxLarge().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Sizes sizes ) {
        switch ( sizes ) {
            case DEFAULT:
                break;
            case S:
                this.getCheckboxSmall().click();
                break;
            case M:
                this.getCheckboxMedium().click();
                break;
            case L:
                this.getCheckboxLarge().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

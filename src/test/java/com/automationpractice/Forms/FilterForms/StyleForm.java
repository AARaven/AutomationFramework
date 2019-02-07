package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Styles;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class StyleForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_id_feature_11']" ) private WebElement checkboxCasual;
    @FindBy( css = "input[id='layered_id_feature_13']" ) private WebElement checkboxGirly;
    @FindBy( css = "input[id='layered_id_feature_16']" ) private WebElement checkboxDressy;
    
    StyleForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxCasual() {
        this.getCheckboxCasual().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxGirly() {
        this.getCheckboxGirly().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxDressy() {
        this.getCheckboxDressy().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Styles styles ) {
        switch ( styles ) {
            case DEFAULT:
                break;
            case CASUAL:
                this.getCheckboxCasual().click();
                break;
            case DRESSY:
                this.getCheckboxDressy().click();
                break;
            case GIRLY:
                this.getCheckboxGirly().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

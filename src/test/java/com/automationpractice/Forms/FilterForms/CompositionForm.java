package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Compositions;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class CompositionForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_id_feature_1']" ) private WebElement checkboxPolyester;
    @FindBy( css = "input[id='layered_id_feature_3']" ) private WebElement checkboxViscose;
    @FindBy( css = "input[id='layered_id_feature_5']" ) private WebElement checkboxCotton;
    
    CompositionForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxPolyester() {
        this.getCheckboxPolyester().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxViscose() {
        this.getCheckboxViscose().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxCotton() {
        this.getCheckboxCotton().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Compositions compositions ) {
        switch ( compositions ) {
            case DEFAULT:
                break;
            case COTTON:
                this.getCheckboxCotton().click();
                break;
            case POLYESTER:
                this.getCheckboxPolyester().click();
                break;
            case VISCOSE:
                this.getCheckboxViscose().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

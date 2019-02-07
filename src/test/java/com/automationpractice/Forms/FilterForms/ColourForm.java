package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Colours;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class ColourForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_id_attribute_group_7']" )  private WebElement checkboxBeige;
    @FindBy( css = "input[id='layered_id_attribute_group_8']" )  private WebElement checkboxWhite;
    @FindBy( css = "input[id='layered_id_attribute_group_11']" ) private WebElement checkboxBlack;
    @FindBy( css = "input[id='layered_id_attribute_group_13']" ) private WebElement checkboxOrange;
    @FindBy( css = "input[id='layered_id_attribute_group_14']" ) private WebElement checkboxBlue;
    @FindBy( css = "input[id='layered_id_attribute_group_15']" ) private WebElement checkboxGreen;
    @FindBy( css = "input[id='layered_id_attribute_group_16']" ) private WebElement checkboxYellow;
    @FindBy( css = "input[id='layered_id_attribute_group_24']" ) private WebElement checkboxPink;
    
    ColourForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxBeige() {
        this.getCheckboxBeige().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxWhite() {
        this.getCheckboxWhite().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxBlack() {
        this.getCheckboxBlack().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxOrange() {
        this.getCheckboxOrange().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxBlue() {
        this.getCheckboxBlue().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxGreen() {
        this.getCheckboxGreen().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxYellow() {
        this.getCheckboxYellow().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxPink() {
        this.getCheckboxPink().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Colours colours ) {
        switch ( colours ) {
            case DEFAULT:
                break;
            case BEIGE:
                this.getCheckboxBeige().click();
                break;
            case BLACK:
                this.getCheckboxBlack().click();
                break;
            case BLUE:
                this.getCheckboxBlue().click();
                break;
            case GREEN:
                this.getCheckboxGreen().click();
                break;
            case ORANGE:
                this.getCheckboxOrange().click();
                break;
            case PINK:
                this.getCheckboxPink().click();
                break;
            case WHITE:
                this.getCheckboxWhite().click();
                break;
            case YELLOW:
                this.getCheckboxYellow().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

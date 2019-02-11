package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Colours;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class ColourForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_id_attribute_group_7']" )  private WebElement checkboxBeige;
    @FindBy ( css = "input[id='layered_id_attribute_group_8']" )  private WebElement checkboxWhite;
    @FindBy ( css = "input[id='layered_id_attribute_group_11']" ) private WebElement checkboxBlack;
    @FindBy ( css = "input[id='layered_id_attribute_group_13']" ) private WebElement checkboxOrange;
    @FindBy ( css = "input[id='layered_id_attribute_group_14']" ) private WebElement checkboxBlue;
    @FindBy ( css = "input[id='layered_id_attribute_group_15']" ) private WebElement checkboxGreen;
    @FindBy ( css = "input[id='layered_id_attribute_group_16']" ) private WebElement checkboxYellow;
    @FindBy ( css = "input[id='layered_id_attribute_group_24']" ) private WebElement checkboxPink;
    
    public ColourForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxBeige() {
        getCheckboxBeige().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxWhite() {
        getCheckboxWhite().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxBlack() {
        getCheckboxBlack().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxOrange() {
        getCheckboxOrange().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxBlue() {
        getCheckboxBlue().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxGreen() {
        getCheckboxGreen().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxYellow() {
        getCheckboxYellow().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxPink() {
        getCheckboxPink().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Colours colours ) {
        switch ( colours ) {
            case DEFAULT:
                break;
            case BEIGE:
                getCheckboxBeige()
                        .click();
                break;
            case BLACK:
                getCheckboxBlack()
                        .click();
                break;
            case BLUE:
                getCheckboxBlue()
                        .click();
                break;
            case GREEN:
                getCheckboxGreen()
                        .click();
                break;
            case ORANGE:
                getCheckboxOrange()
                        .click();
                break;
            case PINK:
                getCheckboxPink()
                        .click();
                break;
            case WHITE:
                getCheckboxWhite()
                        .click();
                break;
            case YELLOW:
                getCheckboxYellow()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

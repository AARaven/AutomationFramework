package com.automationpractice.Forms.FilterForms;

import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class PriceSlideForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( xpath = "//div[@id='layered_price_slider']//a[1]" )
    private WebElement sliderLeftBorder;
    
    @FindBy( xpath = "//div[@id='layered_price_slider']//a[2]" )
    private WebElement sliderRightBorder;
    
    PriceSlideForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage slideLeftToRight( int xOffset, int yOffset ) {
        new Actions( getDriver() ).dragAndDropBy(
                this.getSliderLeftBorder(), xOffset, yOffset );
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage slideRIghtToLeft( int xOffset, int yOffset ) {
        new Actions( getDriver() ).dragAndDropBy(
                this.getSliderRightBorder(), xOffset, yOffset );
        return new CategoryPage( getDriver() );
    }
}

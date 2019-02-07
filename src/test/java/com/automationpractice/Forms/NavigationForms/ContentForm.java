package com.automationpractice.Forms.NavigationForms;

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
public class ContentForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "a[title='Women']" ) private           WebElement buttonWomen;
    // TODO: 07.02.2019
//    @FindBy( css = "a[title='Dresses']" ) private         WebElement buttonDresses;
//    @FindBy( css = "a[title='Casual Dresses']" ) private  WebElement buttonCasualDresses;
//    @FindBy( css = "a[title='Evening Dresses']" ) private WebElement buttonEveningDresses;
//    @FindBy( css = "a[title='Summer Dresses']" ) private  WebElement buttonSummerDresses;
//    @FindBy( css = "a[title='T-shirts']" ) private        WebElement buttonTShirts;
    
    public ContentForm navigateToWomen() {
        new Actions( getDriver() ).moveToElement( this.getButtonWomen() );
        return this;
    }
    
    public ContentForm navigateToDresses() {
        new Actions( getDriver() ).moveToElement(
                this.getButtonWomen(), 200, 0 )
                                  .build()
                                  .perform();
        return this;
    }
    
    public ContentForm navigateToTShirts() {
        new Actions( getDriver() ).moveToElement(
                this.getButtonWomen(), 250, 0 )
                                  .build()
                                  .perform();
        return this;
    }
    
    public CategoryPage clickButtonWomen() {
        this.getButtonWomen().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage click() {
        new Actions( getDriver() ).click().build().perform();
        return new CategoryPage( getDriver() );
    }
    
    public ContentForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}

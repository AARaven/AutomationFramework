package com.automationpractice.Forms.ContentForms;

import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import com.automationpractice.Pages.SecondaryPages.OrderPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class AddCartContainer {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "span[title='Continue shopping']" ) private WebElement buttonContinue;
    @FindBy ( css = "a[title='Proceed to checkout']" ) private  WebElement buttonProceedToCheckout;
    @FindBy ( css = "span[title='Close window']" ) private      WebElement buttonClose;
    
    public CategoryPage clickButtonContinue() {
        new Actions( getDriver() ).moveToElement( this.getButtonContinue() ).build().perform();
        this.getButtonContinue().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickButtonClose() {
        this.getButtonClose().click();
        return new CategoryPage( getDriver() );
    }
    
    public OrderPage clickButtonProceedToCheckout() {
        this.getButtonProceedToCheckout().click();
        return new OrderPage( getDriver() );
    }
    
    AddCartContainer( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver , this );
    }
}

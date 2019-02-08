package com.automationpractice.Pages.SecondaryPages;

import com.automationpractice.Pages.HomePage;
import com.automationpractice.Utils.FrameWorkUtils;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter ( AccessLevel.PRIVATE )
public class OrderPage extends HomePage {
    
    @FindBy ( css = "a[title='Proceed to checkout']" ) private List < WebElement > buttonsProceedToCheckout;
    @FindBy ( css = "a[title='Continue shopping']" ) private   WebElement          buttonContinueShopping;
    @FindBy ( css = "button[name='processAddress']" ) private  WebElement          buttonProcessAddress;
    
    public OrderPage clickButtonProceedToCheckout() {
        FrameWorkUtils.clickElementFromList( this.getButtonsProceedToCheckout() );
        return this;
    }
    
    public OrderPage clickProcessAddress() {
        this.getButtonProcessAddress().click();
        return this;
    }
    
    public OrderPage clickButtonContinueShopping() {
        this.getButtonContinueShopping().click();
        return new OrderPage( getDriver() );
    }
    
    public OrderPage( WebDriver driver ) {
        super( driver );
    }
}

package com.automationpractice.site.pages.ordering;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.tables.CartTable;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class OrderPage extends MainPage {
    
    @FindBy ( css = "a.standard-checkout" ) private           WebElement buttonProceedToCheckout;
    @FindBy ( css = "a[title='Continue shopping']" ) private  WebElement buttonContinueShopping;
    @FindBy ( css = "button[name='processAddress']" ) private WebElement buttonProcessAddress;
    
    CartTable table = new CartTable( getDriver() );
    
    public OrderPage clickButtonProceedToCheckout() {
        getButtonProceedToCheckout().click();
        return this;
    }
    
    public OrderPage clickProcessAddress() {
        getButtonProcessAddress().click();
        return this;
    }
    
    public OrderPage clickButtonContinueShopping() {
        getButtonContinueShopping().click();
        return new OrderPage( getDriver() );
    }
    
    public SoftAssert verifyProducts( Order order ) {
        SoftAssert softAssert = new SoftAssert();
        
        for ( int i = 0 ; i < order.getClothes().size() ; i++ ) {
            softAssert.assertEquals( getTable().getProductQuantity( i ),
                                     order.getClothes().get( i ).getQuantity() );
            softAssert.assertEquals( getTable().getProductName( i ),
                                     order.getClothes().get( i ).getName() );
        }
        return softAssert;
    }
    
    public OrderPage( WebDriver driver ) {
        super( driver );
    }
}
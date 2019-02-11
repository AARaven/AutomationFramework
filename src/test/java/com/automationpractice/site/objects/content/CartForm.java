package com.automationpractice.site.objects.content;

import com.automationpractice.site.pages.ordering.OrderPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class CartForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "a[title='View my shopping cart']" ) private WebElement linkCart;
    @FindBy ( css = "a[title='Check out']" ) private             WebElement buttonCheckout;
    @FindBy ( css = "span[class='ajax_cart_quantity']" ) private WebElement textProductsQuantity;
    
    public OrderPage clickCart() {
        getLinkCart().click();
        return new OrderPage( getDriver() );
    }
    
    public OrderPage clickButtonCheckout() {
        getButtonCheckout().click();
        return new OrderPage( getDriver() );
    }
    
    public SoftAssert verifyProductsInCart( int quantity ) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( quantity, Integer.parseInt( getTextProductsQuantity()
                                                                     .getText() ) );
        return softAssert;
    }
    
    public CartForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}

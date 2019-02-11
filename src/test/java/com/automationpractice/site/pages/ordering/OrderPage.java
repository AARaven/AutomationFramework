package com.automationpractice.site.pages.ordering;

import com.automationpractice.site.MainPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Getter ( AccessLevel.PRIVATE )
public class OrderPage extends MainPage {
    
    @FindBy ( css = "a.standard-checkout" )                  private WebElement          buttonProceedToCheckout;
    @FindBy ( css = "a[title='Continue shopping']" )         private WebElement          buttonContinueShopping;
    @FindBy ( css = "button[name='processAddress']" )        private WebElement          buttonProcessAddress;
    @FindBy ( css = "span[id='summary_products_quantity']" ) private WebElement          textProductsQuantity;
    
    @FindBy ( css = ".cart_quantity_input" ) private List <WebElement> inputsQuantities;
    
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
    
    public SoftAssert verifyProducts( int products ) {
        SoftAssert softAssert = new SoftAssert();
        new Actions( getDriver() ).pause( Duration.ofSeconds( 10 ) );
        softAssert.assertEquals( products, Integer.parseInt( getTextProductsQuantity()
                                                                     .getText()
                                                                     .replaceAll( "\\s*[a-zA-Z]", "" ) ) );
        return softAssert;
    }
    
    public OrderPage addQuantities( Order order ) {
        for ( int i = 0 ; i < order.getClothes().size() ; i++ ) {
            getInputsQuantities().get( i ).clear();
            getInputsQuantities().get( i ).sendKeys(
                    Integer.toString( order.getClothes().get( i ).getQuantity() ) );
        }
        return this;
    }
    
    public OrderPage( WebDriver driver ) {
        super( driver );
    }
}
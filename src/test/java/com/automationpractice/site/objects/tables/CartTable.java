package com.automationpractice.site.objects.tables;

import models.web.table.AbstractWebTable;
import models.web.table.enums.CartBodyColumns;
import models.web.table.enums.CartFooterColumns;
import models.web.table.enums.CartFooterRows;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Getter ( AccessLevel.PROTECTED )
public class CartTable extends AbstractWebTable {
    
    @FindBy ( css = "table[id='cart_summary']" )
    protected WebElement table;
    
    public BufferedImage getProductImage( int index ) throws IOException {
        return ImageIO.read( new URL( getBodyCell( index, CartBodyColumns.PRODUCT )
                                              .findElement( By.cssSelector( "a > img" ) )
                                              .getAttribute( "src" ) ) );
    }
    
    public String getProductName( int index ) {
        return getBodyCell( index, CartBodyColumns.DESCRIPTION )
                .findElement( By.cssSelector( "a" ) )
                .getText();
    }
    
    public String getAvailability( int index ) {
        return getBodyCell( index, CartBodyColumns.AVAILABILITY )
                .getText();
    }
    
    public double getProductPrice( int index ) {
        return Double.parseDouble( getBodyCell( index, CartBodyColumns.UNIT_PRICE )
                                           .findElement( By.cssSelector( ".price" ) )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public int getProductQuantity( int index ) {
        return Integer.parseInt( getBodyCell( index, CartBodyColumns.QUANTITY )
                                         .findElement( By.cssSelector( "input[type='hidden']" ) )
                                         .getAttribute( "value" ) );
    }
    
    public void setProductQuantity( int index, String value ) {
        WebElement inputQuantity = getBodyCell( index, CartBodyColumns.QUANTITY )
                .findElement( By.cssSelector( "input.cart_quantity_input" ) );
        inputQuantity.clear();
        inputQuantity.sendKeys( value );
    }
    
    public void addProductQuantity( int index ) {
        getBodyCell( index, CartBodyColumns.QUANTITY )
                .findElement( By.cssSelector( "a[title='Add']" ) )
                .click();
    }
    
    public void subtractProductQuantity( int index ) {
        getBodyCell( index, CartBodyColumns.QUANTITY )
                .findElement( By.cssSelector( "a[title='Subtract']" ) )
                .click();
    }
    
    public double getProductTotalPrice( int index ) {
        return Double.parseDouble( getBodyCell( index, CartBodyColumns.TOTAL )
                                           .findElement( By.cssSelector( ".price" ) )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public void deleteProductFromCart( int index ) {
        getBodyCell( index, CartBodyColumns.TRASH_BUCKET )
                .findElement( By.cssSelector( "a[title='Delete']" ) )
                .click();
    }
    
    public double getTotalProductsPrice() {
        return Double.parseDouble( getFooterCell( 0, 2 )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public double getTotalShippingPrice() {
        return Double.parseDouble( getFooterCell( CartFooterRows.TOTAL_SHIPPING,
                                                  CartFooterColumns.VALUE )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public double getTotalPriceWithoutTax() {
        return Double.parseDouble( getFooterCell( CartFooterRows.TOTAL_WITHOUT_TAX,
                                                  CartFooterColumns.VALUE )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public double getTax() {
        return Double.parseDouble( getFooterCell( CartFooterRows.TAX,
                                                  CartFooterColumns.VALUE )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public double getTotalPrice() {
        return Double.parseDouble( getFooterCell( CartFooterRows.TOTAL,
                                                  CartFooterColumns.VALUE )
                                           .getText()
                                           .substring( 1 ) );
    }
    
    public CartTable( WebDriver driver ) {
        PageFactory.initElements( driver, this );
    }
}

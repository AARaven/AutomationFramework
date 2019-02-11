package com.automationpractice.tests.OrderingTests;

import com.automationpractice.data.OrderData;
import com.automationpractice.site.objects.content.ProductForm;
import com.automationpractice.site.pages.ordering.OrderPage;
import com.automationpractice.site.pages.ordering.ProductsPage;
import com.automationpractice.tests.BaseTest;
import io.qameta.allure.Step;
import models.order.Clothes;
import models.order.Order;
import models.order.enums.Colours;
import models.order.enums.Sizes;
import org.testng.annotations.Test;

public class CartManageTest extends BaseTest {
    
    @Step ( "Add products to the cart" )
    @Test ( description = "Test that implements filtering categories and adding to cart." )
    public void testAddingProductsInTheCart() {
        
        ProductsPage productsPage = new ProductsPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );
        Clothes      dress        = new Clothes( 5, "2", "Blouse", Sizes.S, Colours.BLACK );
        
        productsPage
                .openPage();
        
        productsPage
                .getFilterForm()
                .filter( dress )
                .waitForLoading();
        
        productsPage
                .getProductForm()
                .navigateToProduct( dress )
                .clickAddToCart()
                .clickButtonProceedToCheckout();
        
        orderPage
                .verifyProducts( 1 )
                .assertAll();
    }
    
    @Step ( "Verify products in the cart" )
    @Test ( description = "",
            dataProvider = "Order", dataProviderClass = OrderData.class )
    public void testVerifyingProductsInTheCart( Order order ) {
        
        ProductsPage productsPage = new ProductsPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );
        ProductForm  productForm  = new ProductForm( getDriver() );
        
        productsPage
                .openPage();
        
        for ( Clothes clothes : order.getClothes() ) {
            productForm
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }
        
        productsPage
                .getCartForm()
                .clickCart();
        
        orderPage.verifyProducts( order.getClothes().size() )
                 .assertAll();
    }
    
    @Step ( "Editing the cart content" )
    @Test ( description = "",
            dataProvider = "Order", dataProviderClass = OrderData.class )
    public void testEditingCartContent( Order order ) {
        
        ProductsPage productsPage = new ProductsPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );
        ProductForm  productForm  = new ProductForm( getDriver() );
        
        productsPage
                .openPage();
        
        
        for ( Clothes clothes : order.getClothes() ) {
            productForm
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }
        
        orderPage
                .openPage();
        
        orderPage
                .addQuantities( order );
        try {
            Thread.sleep( 10000 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        
        orderPage
                .verifyProducts( order.getClothes()
                                      .stream()
                                      .mapToInt( Clothes :: getQuantity )
                                      .sum() )
                .assertAll();
    }
}

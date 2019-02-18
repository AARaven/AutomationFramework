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

import java.util.ArrayList;

public class CartManageTest extends BaseTest {

    @Step ( "Add products to the cart" )
    @Test ( description = "Test that implements filtering categories and adding to cart." )
    public void testAddingProductsInTheCart() {

        ProductsPage productsPage = new ProductsPage( getDriver() );

        Order order = new Order() {{

            setClothes( new ArrayList < Clothes >() {{

                add( Clothes.builder()
                            .name( "Blouse" )
                            .size( Sizes.S )
                            .colour( Colours.BLACK )
                            .quantity( 1 )
                            .build() );

            }} );

        }};

        productsPage
                .open();

        productsPage
                .getFilterForm()
                .filter( order.getClothes().get( 0 ) )
                .waitJQueryAJAXCallsHaveCompleted();

        productsPage
                .getProductForm()
                .navigateToProduct( order.getClothes().get( 0 ) )
                .clickAddToCart()
                .verifyThatProductAddedToCart()
                .assertAll();

        productsPage
                .getAccountRowForm()
                .clickSignOut();
    }

    @Step ( "Verify products in the cart" )
    @Test ( description = "",
            dataProvider = "OrderForVerifying", dataProviderClass = OrderData.class )
    public void testVerifyingProductsInTheCart( Order order ) {

        ProductsPage productsPage = new ProductsPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );

        productsPage
                .open();

        for ( Clothes clothes : order.getClothes() ) {

            productsPage
                    .getProductForm()
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }

        productsPage
                .getCartForm()
                .clickCart();

        orderPage.verifyProducts( order )
                 .assertAll();

        orderPage
                .getAccountRowForm()
                .clickSignOut();
    }

    @Step ( "Editing the cart content" )
    @Test ( description = "",
            dataProvider = "Order", dataProviderClass = OrderData.class )
    public void testEditingCartContent( Order order ) {

        ProductsPage productsPage = new ProductsPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );

        productsPage
                .open();

        for ( Clothes clothes : order.getClothes() ) {
            productsPage
                    .getProductForm()
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }

        orderPage
                .open();

        orderPage
                .setClothesQuantity( order );

        orderPage
                .waitJQueryAJAXCallsHaveCompleted();

        orderPage
                .verifyProducts( order )
                .assertAll();

        orderPage
                .getAccountRowForm()
                .clickSignOut();
    }
}

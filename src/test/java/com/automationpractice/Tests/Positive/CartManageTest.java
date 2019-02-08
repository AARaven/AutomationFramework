package com.automationpractice.Tests.Positive;

import Models.Order.Clothes;
import Models.Order.Enums.*;
import Models.Order.Filter;
import Models.Order.Order;
import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Forms.ContentForms.ProductForm;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import com.automationpractice.Pages.SecondaryPages.OrderPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class CartManageTest extends BaseTest {
    
    @Step ( "Add products to the cart" )
    @Test ( description = "Test that implements filtering categories and adding to cart." )
    public void testAddingProductsInTheCart() {
        CategoryPage categoryPage = new CategoryPage( getDriver() );
        
        categoryPage
                .openPage();
        
        categoryPage
                .getFilterForm()
                .filter( new Filter( Availabilities.IN_STOCK , Categories.DEFAULT , Colours.BLACK ,
                                     Compositions.COTTON , Conditions.NEW , Manufacturers.FASHION ,
                                     Properties.SHORT , Sizes.M , Styles.CASUAL ) )
                
                .getProductForm().navigateToProduct( "Blouse" )
                .clickAddToCart().clickButtonContinue()
                .getCartForm().clickCart();
    }
    
    @Step ( "Verify products in the cart" )
    @Test ( description = "Test that implements ordering (adding to cart)",
            dataProvider = "UserAndOrder", dataProviderClass = UserData.class )
    public void testVerifyingProductsInTheCart( User user , Order order ) {
        
        CategoryPage categoryPage = new CategoryPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );
        
        categoryPage
                .openPage();
        
        for ( Clothes clothes : order.getClothes() ) {
            
            categoryPage
                    .getProductForm()
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }
        
        categoryPage
                .getCartForm()
                .clickCart();
        
        orderPage
                .clickButtonProceedToCheckout()
                .clickProcessAddress()
                .clickButtonProceedToCheckout();
    }
    
    @Step ( "Verify products in the cart" )
    @Test ( description = "Test that implements ordering (adding to cart)",
            dataProvider = "UserAndOrder", dataProviderClass = UserData.class )
    public void testEditingCartContent( User user , Order order ) {
        
        CategoryPage categoryPage = new CategoryPage( getDriver() );
        OrderPage    orderPage    = new OrderPage( getDriver() );
        ProductForm productForm = new ProductForm( getDriver() );
        
        categoryPage
                .openPage();
        
        for ( Clothes clothes : order.getClothes() ) {
            
           productForm
                    .navigateToProduct( clothes )
                    .clickAddToCart()
                    .clickButtonContinue();
        }
        
        categoryPage
                .getCartForm()
                .clickCart();
        
        orderPage
                .clickButtonProceedToCheckout()
                .clickProcessAddress()
                .clickButtonProceedToCheckout();
    }
}

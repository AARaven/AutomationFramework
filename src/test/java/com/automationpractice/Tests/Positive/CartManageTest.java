package com.automationpractice.Tests.Positive;

import Models.Order.Order;
import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class CartManageTest extends BaseTest {
    
    @Step( "pre-alfa" )
    @Test( description = "Test that implements ordering (adding to cart)",
           dataProvider = "UserAndOrder", dataProviderClass = UserData.class )
    public void testSelectOrder( User user, Order order ) {
        
        CategoryPage categoryPage = new CategoryPage( getDriver() );
        
        categoryPage
                .openPage();
        
        categoryPage
                .getFilterForm()
                .filter( order.getClothes()
                              .get( 0 ) );
        
        categoryPage
                .getProductForm()
                .navigateToProduct( order.getClothes()
                                         .get( 0 ) )
                .clickAddToCart();
        
        // TODO: 07.02.2019
    }
    
    @Test
    public void testExample() {
        HomePage home = new HomePage( getDriver() );
        
        home.openPage();
        
        home.getProductForm().navigateToProduct( "" ).clickMore();
        
    }
}

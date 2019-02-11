package com.automationpractice.data;

import models.order.Order;
import org.testng.annotations.DataProvider;

public class OrderData extends Data {
    
    @DataProvider ( name = "Order" )
    public Object[][] getOrder() {
        return new Object[][] { { getData( "Order", Order.class, ORDERS_PATH ) } };
    }
}
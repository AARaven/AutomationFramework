package com.automationpractice.Tests.Positive;//package com.automationpractice.Tests.Positive;
//
//import Models.User.User;
//import com.UserData;
//import com.AccountPage;
//import com.AuthenticationPage;
//import com.HomePage;
//import com.SearchPage;
//import com.BaseTest;
//import io.qameta.allure.Step;
//import org.testng.annotations.Test;
//
//public class OrderTest extends BaseTest {
//
//    @Test( dataProvider = "ValidUser", dataProviderClass = UserData.class,
//           description = "A test that implementing creation an order." )
//    @Step( "Product search and ordering." )
//    public void searchProductAndOrdering( User user ) {
//
//        HomePage           home           = new HomePage( getDriver() );
//        SearchPage         search         = new SearchPage( getDriver() );
//        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
//        AccountPage        account        = new AccountPage( getDriver() );
//
//        home
//                .openPage();
//
//        home
//                .getSearchField()
//                .sendText( "dress" );
//
//        search
//                .chooseProduct( "Printed Dress" )
//                .clickAddToCart()
//                .clickSubmitSummary()
//                .clickSubmitSignIn();
//
//        authentication.authorizeUser( user );
//
//        search
//                .clickSubmitAddress()
//                .clickCheckBoxAgree()
//                .clickProcessCarrier()
//                .clickBankWire()
//                .clickConfirmMyOrder()
//                .verifyOrderIsComplete()
//                .assertAll();
//
//        account.openPage();
//
//        account
//                .clickOrderHistory();
////                .downloadOrderAsPdf();
//
//        account
//                .getAccountRow()
//                .clickSignOut();
//    }
//
////    @Test( description = "A test that implementing verifying that file is downloaded and suffix " +
////                         "is .pdf" )
////    @Step( "Verifying that order was saved as a pdf file" )
////    public void verifyingDownloadedFile() {
////        OrderHistoryPage order = new OrderHistoryPage( getDriver() );
////
////        Assert.assertFalse( order.isDownloaded(), "File with .pdf suffix is not exist." );
////        System.out.println( order.getDownloadFileName() );
////    }
//}

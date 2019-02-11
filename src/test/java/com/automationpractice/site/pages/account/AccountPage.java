package com.automationpractice.site.pages.account;

import com.automationpractice.site.MainPage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class AccountPage extends MainPage {
    
    @FindBy ( css = "a[title='orders']" )       private WebElement buttonOrderHistoryAndDetails;
    @FindBy ( css = "a[title='Credit slips']" ) private WebElement buttonMyCreditSlips;
    @FindBy ( css = "a[title='Addresses']" )    private WebElement buttonMyAddresses;
    @FindBy ( css = "a[title='Information']" )  private WebElement buttonMyPersonalInfo;
    @FindBy ( css = "a[title='My wishlists']" ) private WebElement buttonMyWishlist;
    @FindBy ( css = "a[title='home']" )         private WebElement buttonHome;
    
    public OrderHistoryPage clickOrderHistory() {
        getButtonOrderHistoryAndDetails().click();
        return new OrderHistoryPage( getDriver() );
    }
    
    public CreditSlipsPage clickCreditSlips() {
        getButtonMyCreditSlips().click();
        return new CreditSlipsPage( getDriver() );
    }
    
    public AddressPage clickAddresses() {
        getButtonMyAddresses().click();
        return new AddressPage( getDriver() );
    }
    
    public PersonalInfoPage clickPersonalInfo() {
        getButtonMyPersonalInfo().click();
        return new PersonalInfoPage( getDriver() );
    }
    
    public WishListPage clickMyWishes() {
        getButtonMyWishlist().click();
        return new WishListPage( getDriver() );
    }
    
    public AccountPage( WebDriver driver ) {
        super( driver );
    }
}

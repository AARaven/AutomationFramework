package com.automationpractice.Pages.AccountPages;

import com.automationpractice.Pages.AccountPages.SecondaryPages.*;
import com.automationpractice.Pages.HomePage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter( AccessLevel.PRIVATE )
public class AccountPage extends HomePage {
    
    @FindBy( css = "a[title='Orders']" )       private  WebElement buttonOrderHistoryAndDetails;
    @FindBy( css = "a[title='Credit slips']" ) private  WebElement buttonMyCreditSlips;
    @FindBy( css = "a[title='Addresses']" )    private  WebElement buttonMyAddresses;
    @FindBy( css = "a[title='Information']" )  private  WebElement buttonMyPersonalInfo;
    @FindBy( css = "a[title='My wishlists']" ) private  WebElement buttonMyWishlist;
    @FindBy( css = "a[title='home']" )         private  WebElement buttonHome;
    
    public OrderHistoryPage clickOrderHistory() {
        this.getButtonOrderHistoryAndDetails().click();
        return new OrderHistoryPage( getDriver() );
    }
    
    public CreditSlipsPage clickCreditSlips() {
        this.getButtonMyCreditSlips().click();
        return new CreditSlipsPage( getDriver() );
    }
    
    public AddressPage clickAddresses() {
        this.getButtonMyAddresses().click();
        return new AddressPage( getDriver() );
    }
    
    public PersonalInfoPage clickPersonalInfo() {
        this.getButtonMyPersonalInfo().click();
        return new PersonalInfoPage( getDriver() );
    }
    
    public WishListPage clickMyWishes() {
        this.getButtonMyWishlist().click();
        return new WishListPage( getDriver() );
    }
    
    public AccountPage( WebDriver driver ) {
        super( driver );
    }
}

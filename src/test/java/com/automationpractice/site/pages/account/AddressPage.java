package com.automationpractice.site.pages.account;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.registration.AddressForm;
import com.automationpractice.site.pages.HomePage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class AddressPage extends MainPage {
    
    @FindBy ( css = "a[title='Update']" )         private WebElement buttonUpdate;
    @FindBy ( css = "a[title='Delete']" )         private WebElement buttonDelete;
    @FindBy ( css = "a[title='Add an address']" ) private WebElement buttonAddAddress;
    
    @FindBy ( xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]" )
    private WebElement buttonBack;
    
    @FindBy ( xpath = "//ul[@class='footer_links clearfix']//li[2]//a[1]" )
    private WebElement buttonHome;
    
    private AddressForm getAddressForm() {
        return new AddressForm( getDriver() );
    }
    
    public AddressPage clickUpdate() {
        getButtonUpdate().click();
        return this;
    }
    
    public AddressPage clickDelete() {
        getButtonDelete().click();
        return this;
    }
    
    public AddressPage clickAddAddress() {
        getButtonAddAddress().click();
        return this;
    }
    
    public AddressPage clickBack() {
        getButtonBack().click();
        return this;
    }
    
    public HomePage clickHome() {
        getButtonHome().click();
        return new HomePage( getDriver() );
    }
    
    public AddressPage( WebDriver driver ) {
        super( driver );
    }
}

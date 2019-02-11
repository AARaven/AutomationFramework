package com.automationpractice.site.pages.account;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.pages.HomePage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class OrderHistoryPage extends MainPage {
    
    @FindBy ( xpath = "//span[contains(text(),'Home')]" )
    private WebElement buttonHome;
    
    @FindBy ( xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]//span[1]" )
    private WebElement buttonBack;
    
    @FindBy ( className = "link-button" )
    private WebElement linkPdf;
    
    public HomePage clickHome() {
        getButtonHome().click();
        return new HomePage( getDriver() );
    }
    
    public AccountPage clickBack() {
        getButtonBack().click();
        return new AccountPage( getDriver() );
    }
    
    public OrderHistoryPage( WebDriver driver ) {
        super( driver );
    }
}
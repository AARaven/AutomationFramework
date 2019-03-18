package com.sperasoft.edu.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    private static final String URL = "https://www.google.com";

    private WebDriver driver;

    @FindBy ( css = "input[title='Поиск']" )
    private WebElement inputSearchRequest;

    private WebDriver getDriver() {
        return driver;
    }

    private WebElement getInputSearchRequest() {
        return inputSearchRequest;
    }

    public GooglePage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements( driver , this );
    }

    public void openPage() {
        getDriver().get( URL );
    }

    public void sendSearchRequest( String text ) {
        getInputSearchRequest().sendKeys( text );
        getInputSearchRequest().submit();
    }
}

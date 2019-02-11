package com.automationpractice.site.objects.text;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class MessageForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "textarea[id=message]" ) private WebElement inputMessage;
    
    public MessageForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public MessageForm sendText( String text ) {
        getInputMessage().clear();
        getInputMessage().sendKeys( text );
        return this;
    }
}

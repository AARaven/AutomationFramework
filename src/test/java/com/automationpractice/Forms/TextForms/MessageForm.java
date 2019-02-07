package com.automationpractice.Forms.TextForms;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class MessageForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "textarea[id=message]" )
    private WebElement inputMessage;
    
    private WebElement getInputMessage() {
        return this.inputMessage;
    }
    
    public MessageForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public MessageForm sendText( String text ) {
        this.getInputMessage().clear();
        this.getInputMessage().sendKeys( text );
        return this;
    }
}

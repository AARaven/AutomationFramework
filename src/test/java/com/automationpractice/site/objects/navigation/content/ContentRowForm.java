package com.automationpractice.site.objects.navigation.content;

import com.automationpractice.site.objects.navigation.content.Elements.DressesForm;
import com.automationpractice.site.objects.navigation.content.Elements.TShirtsForm;
import com.automationpractice.site.objects.navigation.content.Elements.WomenForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class ContentRowForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    public ContentRowForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public WomenForm getWomenForm() {
        return new WomenForm( getDriver() );
    }
    
    public DressesForm getDressesForm() {
        return new DressesForm( getDriver() );
    }
    
    public TShirtsForm getTShirtsForm() {
        return new TShirtsForm( getDriver() );
    }
}

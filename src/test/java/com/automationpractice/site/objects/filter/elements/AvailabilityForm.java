package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Availabilities;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class AvailabilityForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_quantity_0']" ) ,
                 @FindBy ( css = "input[id='layered_quantity_1']" ) } )
    private WebElement checkboxInStock;

    @FindBy ( css = "ul[id='ul_layered_quantity_0']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public AvailabilityForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Availabilities availabilities ) {
        switch ( availabilities ) {
            case DEFAULT:
                break;
            case IN_STOCK:
                getCheckboxInStock()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

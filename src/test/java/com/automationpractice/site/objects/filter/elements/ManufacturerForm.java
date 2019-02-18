package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Manufacturers;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


@Getter ( AccessLevel.PRIVATE )
public class ManufacturerForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_manufacturer_0']" ) ,
                 @FindBy ( css = "input[id='layered_manufacturer_1']" ) } )
    private WebElement checkboxFashion;

    @FindBy ( css = "ul[id='ul_layered_manufacturer_0']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ManufacturerForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Manufacturers manufacturers ) {
        switch ( manufacturers ) {
            case DEFAULT:
                break;
            case FASHION:
                getCheckboxFashion()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

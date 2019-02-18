package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Sizes;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class SizeForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_1']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_1']" ) } )
    private WebElement checkboxSmall;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_1']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_2']" ) } )
    private WebElement checkboxMedium;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_1']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_3']" ) } )
    private WebElement checkboxLarge;

    @FindBy ( css = "ul[id='ul_layered_id_attribute_group_1']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public SizeForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Sizes sizes ) {
        switch ( sizes ) {
            case DEFAULT:
                break;
            case S:
                getCheckboxSmall()
                        .click();
                break;
            case M:
                getCheckboxMedium()
                        .click();
                break;
            case L:
                getCheckboxLarge()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Conditions;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class ConditionForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_condition_0']" ) ,
                 @FindBy ( css = "input[id='layered_condition_new']" ) } )
    private WebElement checkboxNew;

    @FindBy ( css = "ul[id='ul_layered_condition_0']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ConditionForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Conditions conditions ) {
        switch ( conditions ) {
            case DEFAULT:
                break;
            case NEW:
                getCheckboxNew()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
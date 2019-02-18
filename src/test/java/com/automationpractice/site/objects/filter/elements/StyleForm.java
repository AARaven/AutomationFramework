package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Styles;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class StyleForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul_layered_id_feature_6" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_11']" ) } )
    private WebElement checkboxCasual;
    @FindBys ( { @FindBy ( css = "ul_layered_id_feature_6" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_13']" ) } )
    private WebElement checkboxGirly;
    @FindBys ( { @FindBy ( css = "ul_layered_id_feature_6" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_16']" ) } )
    private WebElement checkboxDressy;

    @FindBy ( css = "ul[id='ul_layered_id_feature_6']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public StyleForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Styles styles ) {
        switch ( styles ) {
            case DEFAULT:
                break;
            case CASUAL:
                getCheckboxCasual()
                        .click();
                break;
            case DRESSY:
                getCheckboxDressy()
                        .click();
                break;
            case GIRLY:
                getCheckboxGirly()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Compositions;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class CompositionForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_5']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_1']" ) } )
    private WebElement checkboxPolyester;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_5']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_3']" ) } )
    private WebElement checkboxViscose;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_5']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_5']" ) } )
    private WebElement checkboxCotton;

    @FindBy ( css = "ul[id='ul_layered_id_feature_5']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public CompositionForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Compositions compositions ) {
        switch ( compositions ) {
            case DEFAULT:
                break;
            case COTTON:
                getCheckboxCotton()
                        .click();
                break;
            case POLYESTER:
                getCheckboxPolyester()
                        .click();
                break;
            case VISCOSE:
                getCheckboxViscose()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
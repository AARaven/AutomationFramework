package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Properties;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class PropertyForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_7']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_17']" ) } )
    private WebElement checkboxShortSleeve;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_7']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_18']" ) } )
    private WebElement checkboxColorfulDress;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_7']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_19']" ) } )
    private WebElement checkboxShortDress;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_7']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_20']" ) } )
    private WebElement checkboxMidiDress;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_feature_7']" ) ,
                 @FindBy ( css = "input[id='layered_id_feature_21']" ) } )
    private WebElement checkboxMaxiDress;

    @FindBy ( css = "ul[id='ul_layered_id_feature_7']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public PropertyForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Properties properties ) {
        switch ( properties ) {
            case DEFAULT:
                break;
            case COLORFUL:
                getCheckboxColorfulDress()
                        .click();
                break;
            case MAXI:
                getCheckboxMaxiDress()
                        .click();
                break;
            case MIDI:
                getCheckboxMidiDress()
                        .click();
                break;
            case SHORT:
                getCheckboxShortSleeve()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
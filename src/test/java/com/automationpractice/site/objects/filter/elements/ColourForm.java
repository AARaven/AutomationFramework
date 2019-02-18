package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Colours;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class ColourForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_7']" ) } )
    private WebElement checkboxBeige;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_8']" ) } )
    private WebElement checkboxWhite;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_11']" ) } )
    private WebElement checkboxBlack;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_13']" ) } )
    private WebElement checkboxOrange;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_14']" ) } )
    private WebElement checkboxBlue;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_15']" ) } )
    private WebElement checkboxGreen;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_16']" ) } )
    private WebElement checkboxYellow;
    @FindBys ( { @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" ) ,
                 @FindBy ( css = "input[id='layered_id_attribute_group_24']" ) } )
    private WebElement checkboxPink;

    @FindBy ( css = "ul[id='ul_layered_id_attribute_group_3']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ColourForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Colours colours ) {
        switch ( colours ) {
            case DEFAULT:
                break;
            case BEIGE:
                getCheckboxBeige()
                        .click();
                break;
            case BLACK:
                getCheckboxBlack()
                        .click();
                break;
            case BLUE:
                getCheckboxBlue()
                        .click();
                break;
            case GREEN:
                getCheckboxGreen()
                        .click();
                break;
            case ORANGE:
                getCheckboxOrange()
                        .click();
                break;
            case PINK:
                getCheckboxPink()
                        .click();
                break;
            case WHITE:
                getCheckboxWhite()
                        .click();
                break;
            case YELLOW:
                getCheckboxYellow()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

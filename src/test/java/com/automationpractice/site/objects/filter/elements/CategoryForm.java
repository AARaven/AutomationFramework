package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.enums.Categories;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class CategoryForm extends AbstractWebForm {

    @FindBy ( css = "input[id='layered_category_9']" )
    private WebElement checkboxCasualDresses;
    @FindBy ( css = "input[id='layered_category_10']" )
    private WebElement checkboxEveningDresses;
    @FindBy ( css = "input[id='layered_category_11']" )
    private WebElement checkboxSummerDresses;

    @FindBy ( css = "ul[id='ul_layered_category_0']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public CategoryForm( WebDriver driver ) {
        super( driver );
    }

    public FilterForm filter( Categories categories ) {
        switch ( categories ) {
            case DEFAULT:
                break;
            case CASUAL:
                getCheckboxCasualDresses()
                        .click();
                break;
            case EVENING:
                getCheckboxEveningDresses()
                        .click();
                break;
            case SUMMER:
                getCheckboxSummerDresses()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}

package com.automationpractice.site.objects.content;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryProductsForm {
    
    @FindBy ( css = "span[id=''summary_products_quantity]" ) private WebElement counterSummary;
}

package com.automationpractice.site.pages.ordering;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.content.CartForm;
import com.automationpractice.site.objects.content.ProductForm;
import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter ( AccessLevel.PRIVATE )
public class ProductsPage extends MainPage {

    public CartForm getCartForm() {
        return new CartForm( getDriver() );
    }

    public FilterForm getFilterForm() {
        return new FilterForm( getDriver() );
    }

    public ProductForm getProductForm() {
        return new ProductForm( getDriver() );
    }

    public ProductsPage( WebDriver driver ) {
        super( driver );
    }
}

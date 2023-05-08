package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.ProductPage;
import com.tutorialninja.pages.ShoppingCart;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DeskTopsPageTest extends BaseTest {
    DesktopsPage deskTopsPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCart cartPage; //


    @BeforeMethod
    public void inIt() {
        deskTopsPage = new DesktopsPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCart(); //

    }
    @Test(groups = {"Sanity" , "Regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        deskTopsPage.mouseHoverOnDesktopsAndClick();
        deskTopsPage.clickOnShowAllDeskTops();
        deskTopsPage.sortingDesktopsFromZtoA(("Name (Z - A)"));
        ArrayList<String> originalProductsName = deskTopsPage.getProductsNameList();
        Collections.reverse(originalProductsName);
        ArrayList<String> afterSortByZToAProductsName = deskTopsPage.getProductsNameList();
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }
    @Test (groups = {"Smoke" , "Regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenuBar("Show All Desktops");
        deskTopsPage.selectSortByOption("Name (A - Z)");
        deskTopsPage.selectProductByName("HP LP3065");
        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),"Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");
        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}





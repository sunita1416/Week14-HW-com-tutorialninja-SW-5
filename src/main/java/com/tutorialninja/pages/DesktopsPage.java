package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement lookUpDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllDesktops')]")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByPosition;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    public void mouseHoverOnDesktopsAndClick() {
        clickOnElement(lookUpDesktops);

    }

    public void clickOnShowAllDeskTops() {
        clickOnElement(showAllDesktops);
    }

    public void sortingDesktopsFromZtoA(String name) {
        selectByVisibleTextFromDropDown(sortByPosition, name);

    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }
    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}

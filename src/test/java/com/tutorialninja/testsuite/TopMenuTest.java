package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.ComponentsPage;
import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopsPage deskTops;
    LaptopsAndNoteBooksPage laptopsAndNoteBooks;
    ComponentsPage componentsPage;
    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        deskTops = new DesktopsPage();
        laptopsAndNoteBooks = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }
    @Test(groups = {"Sanity" , "Smoke", "Regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        deskTops.mouseHoverOnDesktopsAndClick();
        homePage.selectMenuBar("Show AllDesktops");
        // homePage.clickOnShowAllDeskTops();
        laptopsAndNoteBooks.mouseHoverOnLaptopsAndNoteBooksAndClick();
        laptopsAndNoteBooks.clickOnShowAllLaptopsAndNotebooks();
        componentsPage.mouseHoverOnComponentsAndClick();
        componentsPage.clickOnShowAllComponents();


    }
}

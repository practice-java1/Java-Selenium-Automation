package pageObjectTests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.sauceDemo.*;
import utils.TestBase;

import static pageObjectTests.LogInTests.log;

public class SauceLogInPageTests extends TestBase {

    LogInPage sauceLogInPage = new LogInPage(driver);

    @Test
    public void sauceTest() {
        driver.get("https://www.saucedemo.com/");
        sauceLogInPage.doTheLoginActions("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals("The title is wrong", "Products", productsPage.getProductTitlePage());

        productsPage.addProductToCart();
        productsPage.openCartPage();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals("The product description is wrong", "Sauce Labs Backpack", cartPage.getProductDescription());

        //TEMA - Assert - pret, cantitate
        // CheckOutPage
        Assert.assertEquals("The product quantity is wrong", 1, cartPage.getProductQuantity());

        Assert.assertEquals("The product price is wrong", "$29.99", cartPage.getProductPrice());
        cartPage.clickCheckoutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertEquals("The title is wrong", "Checkout: Your Information", checkOutPage.getPageTitle());
        checkOutPage.enterFirstName("Ioana");
        checkOutPage.enterLastName("Ioana");
        checkOutPage.enterPostalCode(700685);
        checkOutPage.clickContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals("The page title is wrong", "Checkout: Overview", checkoutOverviewPage.getPageTitle());


        Assert.assertEquals("The total order price is wrong", 32.39, checkoutOverviewPage.getTotalPrice(), 0.1);

        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals("The page title is wrong", "Checkout: Complete!", checkoutCompletePage.getPageTitle());

        Assert.assertEquals("The message is not displayed", "Thank you for your order!", checkoutCompletePage.getThankYouForYourOrderMessage());
        checkoutCompletePage.clickBackHomeButton();

        ProductsPage productsPage1 = new ProductsPage(driver);
        productsPage1.getProductTitlePage();
        Assert.assertEquals("Failed to return to Product page", "Products", productsPage1.getProductTitlePage());

    }
}

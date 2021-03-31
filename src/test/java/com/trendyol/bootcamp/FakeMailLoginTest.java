package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FakeMailLoginTest extends BaseTest{

    @Test
    public void LoginFakeAddBasketTest() throws InterruptedException {

        HomePage homePage = new HomePage(webDriver);
        homePage.goToHomePage();
        ProductList productList = homePage.clickHowerTV();

        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,500)");

        productList.shouldAddFirstElementBasket();

        String productTitle = productList.getTitle();

        String ProductValue = productList.getValueOfProduct(By.className("prc-box-dscntd"));

        BasketPage basketPage = productList.clickBasket();


        String actualProductTitle = basketPage.getTitleProduct();

        String actualProductValue = basketPage.getValueOfProduct(By.className("pb-basket-item-price"));

        Assert.assertEquals(productTitle, actualProductTitle);

        ProductValue.contains(actualProductValue);

        // Giriş yaptıktan sonra check
        String actualText = "Hesabım";

        TakeMail takeMail = new TakeMail(webDriver);
        String mail = takeMail.takeFakeMail();

        User fakeUser = new User(mail,"1234qwe");

        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.getSignUpPage();

        signUpPage.SignUp(fakeUser.getEmail(), fakeUser.getPassword());

        homePage.goBackToHomePage();

        String accountText = homePage.getAccountUser();

        Assert.assertEquals(accountText,actualText);

        //GO BASKET AND CHECK
        productList.clickBasket();

        String afterSignActualProductTitle = basketPage.getTitleProduct();
        Assert.assertEquals(actualProductTitle,afterSignActualProductTitle);

        String afterActualProductValue = basketPage.getValueOfProduct();
        afterActualProductValue.contains(actualProductValue);



    }
}

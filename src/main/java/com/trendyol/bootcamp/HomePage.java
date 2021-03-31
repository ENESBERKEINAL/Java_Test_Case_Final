package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage{


    String homePageUrl = "https://www.trendyol.com/";
    By fancyBox = By.className("fancybox-close");
    By accountUserBy = By.className("account-user");
    By electronicField = By.cssSelector("a[href='/butik/liste/elektronik']");
    By tvDisplaySoundBy = By.cssSelector("a[href='/tv-goruntu-ses-sistemleri-x-c104035']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToHomePage(){
        webDriver.get(homePageUrl);
        click(fancyBox,3);
    }

    public void goBackToHomePage(){
        webDriver.get(homePageUrl);
    }

    public String  getAccountUser(){
        return getText(accountUserBy);
    }
    public ProductList clickHowerTV(){
        stableHover(electronicField);
        click(tvDisplaySoundBy,3);
        return new ProductList(webDriver);
    }


}

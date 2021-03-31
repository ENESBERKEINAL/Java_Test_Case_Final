package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitleProduct() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pb-item"))).getAttribute("title");
    }

    public String getValueOfProduct() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pb-basket-item-price"))).getText();
    }
}

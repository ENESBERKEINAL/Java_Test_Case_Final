package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductList extends BasePage{
    By addToBasketBy = By.className("add-to-basket-button");
    By basketButtonBy = By.className("account-basket");
    public ProductList(WebDriver webDriver) {
        super(webDriver);
    }

    public void shouldAddFirstElementBasket() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.navigate().refresh();
            List<WebElement> productList =  webDriver.findElements(addToBasketBy);
            productList.get(0).click();
        }
    public BasketPage clickBasket(){
        click(basketButtonBy,5);
        return new BasketPage(webDriver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prdct-desc-cntnr-ttl"))).getAttribute("title") + " " + wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prdct-desc-cntnr-name"))).getText();
    }

    public String getValueOfProduct() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prc-box-dscntd"))).getText();
    }
}

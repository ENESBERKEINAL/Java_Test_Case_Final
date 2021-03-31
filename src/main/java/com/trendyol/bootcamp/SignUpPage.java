package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{

    By emailBy = By.id("register-email");
    By passwordBy = By.id("register-password-input");
    By submitBy = By.className("submit");
    private By componentListBy = By.className("component-list");
    WebDriverWait wait;
    public SignUpPage(WebDriver webDriver){
        super(webDriver);
        wait = new WebDriverWait(super.webDriver, 15);
    }
    public void getSignUpPage(){
        webDriver.get("https://www.trendyol.com/uyelik");
    }

    public HomePage SignUp(String email,String password){

        sendKeys(emailBy,email);
        sendKeys(passwordBy,password);

        click(submitBy,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentListBy));
        return new HomePage(webDriver);
    }

}

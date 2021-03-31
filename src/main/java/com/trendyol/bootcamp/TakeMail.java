package com.trendyol.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakeMail extends BasePage{

    String url = "https://10minutemail.net/?lang=tr";
    By valueIdBy = By.id("fe_text");
    public TakeMail(WebDriver webDriver){
        super(webDriver);
    }

    public String takeFakeMail(){
        webDriver.get(url);
        return webDriver.findElement(valueIdBy).getAttribute("value");
    }


}

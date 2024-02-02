package com.flipkart.pom;

import com.flipkart.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass {

    //class
    private static final String closeLoginPopUp = "_30XB9F";
    private static final String searchBox = "Pke_EE";

    public HomePage closeLoginPopUp(){
        try {
            WebElement closeButton = driver.findElement(By.className(closeLoginPopUp));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }
        } catch (NoSuchElementException e){
            e.getStackTrace();
        }
        return getHomePage();
    }

    public HomePage searchProduct(String product) {
        driver.findElement(By.className(searchBox)).sendKeys(product);
        driver.findElement(By.className(searchBox)).sendKeys(Keys.RETURN);
        return getHomePage();
    }


}

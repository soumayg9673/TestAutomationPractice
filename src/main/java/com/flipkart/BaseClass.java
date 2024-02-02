package com.flipkart;

import org.openqa.selenium.WebDriver;

import com.flipkart.pom.HomePage;

public class BaseClass {

    public static WebDriver driver;

    private HomePage homePage;

    public HomePage getHomePage() {
        if (homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public BaseClass(){}

    public BaseClass(WebDriver tempDriver){
        driver = tempDriver;
        homePage = getHomePage();
    }

}

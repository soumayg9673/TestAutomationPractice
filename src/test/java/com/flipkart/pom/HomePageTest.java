package com.flipkart.pom;

import inittest.BaseClassTest;
import inittest.ListenerTest;
import org.junit.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(ListenerTest.class)
public class HomePageTest extends BaseClassTest{

    @BeforeTest
    public void closePopUp() {
        baseClass.getHomePage().closeLoginPopUp();
    }

    @Test
    public void searchProduct() {
        baseClass
                .getHomePage()
                .searchProduct("POCO");
    }

}

package com.flipkart.pom;

import inittest.BaseClassTest;
import inittest.ListenerTest;
import org.junit.Test;

public class HomePageTest extends BaseClassTest{

    @Test
    public void searchProduct() {
        baseClass
                .getHomePage()
                .closeLoginPopUp()
                .getHomePage()
                .searchProduct("POCO");
    }

}

package com.demo.nopcommerce.tests;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {
    WebDriver driver;
    BasePage basePage;
    Properties properties;
    RegisterPage registerPage;

    @BeforeMethod
public void openBrowser(){
    basePage = new BasePage();
    properties = basePage.initialiseProperties();
    String webEngine = properties.getProperty("browser");
    driver = basePage.initialiseDriver(webEngine);
    driver.get(properties.getProperty("url"));
    registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){
        Assert.assertEquals(registerPage.getPageTitle(),"nopCommerce demo store. Register",
                "Register page title does not match");
    }

    @Test(priority = 2)
    public void registerTest() throws InterruptedException {

        registerPage.toRegister(properties.getProperty("Firstname"),properties.getProperty("Lastname"),
                properties.getProperty("Email"),properties.getProperty("Password"));
        Thread.sleep(1000);
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }

}

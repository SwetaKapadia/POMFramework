package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Utilities.Constants;
import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    Utils utils;

        By gender = By.id("gender-female");
        By firstName = By.id("FirstName");
        By lastName = By.id("LastName");
        By dobDay = By.className("DateOfBirthDay");
        By dobMonth = By.className("DateOfBirthMonth");
        By dobYear = By.className("DateOfBirthYear");
        By email = By.id("Email");
        By password = By.id("Password");
        By confirmPW = By.id("ConfirmPassword");
        By registerButton = By.id("register-button");

        public RegisterPage(WebDriver driver){
            this.driver = driver;
            utils = new Utils(driver);

        }

        public String getPageTitle(){
            return utils.waitForTitlePresent(Constants.Register_Page_Title,5);
        }

        public void toRegister(String firstname, String lastname, String eMail, String pwd){

            utils.toClick(gender);
            utils.toSendKey(firstName,firstname);
            utils.toSendKey(lastName,lastname);
            utils.selectValueDDNum(dobDay,1);
            utils.selectValueFromDropDown(dobMonth,"January");
            utils.selectValueDDNum(dobYear,2000);
            utils.toSendKey(email,eMail);
            utils.toSendKey(password,pwd);
            utils.toSendKey(confirmPW,pwd);
            utils.toClick(registerButton);

        }
}

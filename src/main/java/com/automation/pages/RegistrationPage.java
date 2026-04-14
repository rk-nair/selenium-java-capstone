package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.WaitUtils;

public class RegistrationPage {


    private WebDriver driver;

    // ================= LOCATORS =================
    private By registerLink = By.xpath("//a[@class='ico-register']");
    private By femaleGender = By.id("gender-female");
    private By maleGender = By.id("gender-male");
    private By firstNameField = By.id("FirstName");
    private By lastnameFiled = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By RegisterButton = By.id("register-button");
    private By successMessage = By.cssSelector(".result");
    private By errorMessage = By.xpath("//div[@class='validation-summary-errors']//li");

    // ================= CONSTRUCTOR =================
    public RegistrationPage(WebDriver driver)
    {
     this.driver= driver;
    }

    // ================= ACTIONS =================

    public void clickRegisterLink()
    {
        WaitUtils.waitForClickable(driver, registerLink).click();
    }

    public void register(String gender,String firstName, String lastName, String email,String password)
    {
       // WaitUtils.waitForClickable(driver, registerLink).click();

        if(gender.equalsIgnoreCase("male")){
            WaitUtils.waitForClickable(driver, maleGender).click();
        } else if (gender.equalsIgnoreCase("female")) {
            WaitUtils.waitForClickable(driver, femaleGender).click();            
        }

        WaitUtils.waitForVisibility(driver, firstNameField).sendKeys(firstName);
        WaitUtils.waitForVisibility(driver, lastnameFiled).sendKeys(lastName);
        WaitUtils.waitForVisibility(driver, emailField).sendKeys(email);
        WaitUtils.waitForVisibility(driver, passwordField).sendKeys(password);
        WaitUtils.waitForVisibility(driver, confirmPassword).sendKeys(password);
        WaitUtils.waitForClickable(driver, RegisterButton).click();
    }

    // ================= VALIDATIONS =================

    public String getSuccessMessage() {
        return WaitUtils.waitForVisibility(driver, successMessage).getText();
    }

    public String getRegistrationError() {
        return WaitUtils.waitForVisibility(driver, errorMessage).getText();
    }
    
}

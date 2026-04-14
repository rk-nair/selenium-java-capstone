package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.RegistrationPage;



public class RegistrationTest extends BaseTest {

    
    @Test(description = "Valid Registration")

    public void verifyValidRegistration(){
        RegistrationPage regisetrPage = new RegistrationPage(driver);
        regisetrPage.clickRegisterLink();

        String email ="user"+System.currentTimeMillis()+"@gmail.com";

      regisetrPage.register(config.getProperty("gender"),config.getProperty("firstName"), 
      config.getProperty("lastName"),email,
       config.getProperty("password"));

    String actualMessage = regisetrPage.getSuccessMessage();
    Assert.assertEquals(actualMessage,"Your registration completed");

    
    }

    @Test(description = "VerifyExistingUser") 
    
    public void VerifyExistingUser()
    {
        RegistrationPage regisetrPage = new RegistrationPage(driver);
        regisetrPage.clickRegisterLink();

      regisetrPage.register(config.getProperty("gender"),config.getProperty("firstName"), 
      config.getProperty("lastName"), config.getProperty("email"),
       config.getProperty("password"));

    Assert.assertTrue(regisetrPage.getRegistrationError().contains("The specified email already exists"));

    }

}

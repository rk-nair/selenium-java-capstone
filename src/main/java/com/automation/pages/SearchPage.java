package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utils.WaitUtils;

public class SearchPage {


    private WebDriver driver;
    // ================= LOCATORS =================

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input[value='Search']");
    private By productTitles = By.cssSelector(".product-title a");
    private By noResultMessage = By.cssSelector("strong.result");

    // ================= CONSTRUCTOR =================

    public SearchPage(WebDriver driver)
    {
     this.driver= driver;
    }

    // ================= ACTIONS =================
    

    public void searchProduct(String productName)
    {
      WaitUtils.waitForVisibility(driver, searchBox).clear();  
      WaitUtils.waitForVisibility(driver, searchBox).sendKeys(productName);
      WaitUtils.waitForClickable(driver, searchButton).click();
    }

    // ================= VALIDATIONS =================

    public boolean isAnyProductContainsKeyword(String keyword) {  

        WaitUtils.waitForVisibility(driver, productTitles);
        List<WebElement> products = driver.findElements(productTitles);
        for (WebElement product : products) {
            if (product.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;

    }


    public boolean isNoProductFound() {
      return WaitUtils.waitForVisibility(driver, noResultMessage).isDisplayed(); 
    }
    
}

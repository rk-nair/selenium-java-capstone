package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.SearchPage;
import org.testng.Assert;

public class SearchTest extends BaseTest{

    @Test(description = "Verify Search Functionality")
    public void verifySearchFunctionality()
    {
        SearchPage searchPage = new SearchPage(driver);
        String keyword = config.getProperty("searchProduct");
        searchPage.searchProduct(keyword);
        Assert.assertTrue(searchPage.isAnyProductContainsKeyword(keyword), "No products found with keyword: " + keyword);
    }
    @Test(description = "Verify Invalid Search")
    public void verifyInvalidSearch()
    {
        SearchPage searchPage = new SearchPage(driver);
        String keyword = config.getProperty("invalidSearchProduct");
        searchPage.searchProduct(keyword);
        Assert.assertTrue(searchPage.isNoProductFound(), "Expected no results but products were found for " + keyword);
    }
}

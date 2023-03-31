package com.cydeo.utilities;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

 /*
   this method will accept int(in seconds)
   and execute Thread.sleep for given duration
    */

    public static void sleep(int second){
        second *=1000;

        try{
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl: for verify if the url contains given String
    - If condition matches, will break loop
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify( String expectedInURL, String expectedInTitle){

        //Create a logic to switch to  the tab where Etsy.com is open
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //Assert: Title contains "expectedInTitle"
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    //This method will verify if the current URL contains expected value.
    public static void verifyURLContains(String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInTitle));
    }


    /**
     * This method will accept a dropdown as a WebElement and return
     * all of the options' text in a List of String.
     * @param dropdownElement
     * @return List</String> actualOptionsAsString
     */

    public static List<String> dropdownOptionAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;

    }

    /**
     * This method will accept a group radio buttons as a list of WebElement
     * It will loop through the list and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
            }

        }

    }

}

package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllORdersPage extends BasePage {

    public ViewAllORdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //We need to locate the first cell of the first row
    @FindBy(xpath = "//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]")
    public WebElement newCustomerCell;


}

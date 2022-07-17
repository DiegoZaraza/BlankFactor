package org.blankfactor.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsightPage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div/div/article[1]/div/div[2]/a")
    WebElement goToBlog;

    public InsightPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setGoToBlog() {
        click(goToBlog, "");
    }
}

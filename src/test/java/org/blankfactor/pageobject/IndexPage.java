package org.blankfactor.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"menu-item-4436\"]/a")
    WebElement linkInsight;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setLinkInsight() {
        click(linkInsight, "Click on link Insight");
    }
}

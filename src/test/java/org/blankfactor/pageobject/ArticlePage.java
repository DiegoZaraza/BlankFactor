package org.blankfactor.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"post_content\"]/h2[1]")
    WebElement title;

    public ArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return getText(title, "");
    }
}

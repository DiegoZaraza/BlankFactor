package org.blankfactor.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsightPage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div/div/article[1]/div/div[2]/a")
    WebElement goToBlog;
    @FindBy(name = "Email")
    WebElement txtEMailSubscriber;
    @FindBy(id = "form-newsletter-insights-submit-btn")
    WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section[2]/div/form/span")
    WebElement errorSubscriber;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/section[2]/div/form/div[2]")
    WebElement succesMessage;

    public InsightPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setGoToBlog() {
        click(goToBlog, "");
    }

    public void setTxtEMailSubscriber(String value) {
        sendKeys(txtEMailSubscriber, value, "");
    }

    public void setBtnSubmit() {
        click(btnSubmit, "");
    }

    public Boolean getErrorMessage() {
        waitForVisibility(errorSubscriber);
        return isDisplayed(errorSubscriber, "");
    }

    public Boolean getSuccessMessage() {
        waitForVisibility(succesMessage);
        return isDisplayed(succesMessage, "");
    }
 }

package org.blankfactor.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlogPage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div/div[2]/div[2]/button")
    WebElement buttonLoadMore;

    @FindBy(xpath = "//div[@class='posts-list']/article")
    List<WebElement> articles;

    public BlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setButtonLoadMore(){
        click(buttonLoadMore, "");
    }

    public void setArticles(){
        findObject(articles, "");
    }

    public void searchArticle(String value) throws InterruptedException {
        String title;
        Boolean band = true;
        while(band){
            for (WebElement article : articles) {
                title = article.getText();
                if(title.contains(value)) {
                    click(article.findElement(By.tagName("a")), "");
                    band = false;
                    break;
                }
            }
            Thread.sleep(3000);
            if(band)
                setButtonLoadMore();
        }
    }
}
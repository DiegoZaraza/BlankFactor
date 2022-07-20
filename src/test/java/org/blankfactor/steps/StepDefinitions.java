package org.blankfactor.steps;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.blankfactor.pageobject.*;
import org.blankfactor.utilities.PropertiesRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("URL");
    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private IndexPage indexPage;
    private Faker faker;

    private BlogPage blogPage;
    private InsightPage insightPage;
    private ArticlePage articlePage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = WebDriverManager.chromedriver().create();
        indexPage = new IndexPage(webDriver);
        insightPage = new InsightPage(webDriver);
        blogPage = new BlogPage(webDriver);
        articlePage = new ArticlePage(webDriver);
        softAssertions = new SoftAssertions();
        faker = new Faker();
        webDriver.manage().window().maximize();
        BasePage.setImplicitlyWait();
    }

    @Given("Navigate to blankfactor.com")
    public void navigateToBlankfactorCom() {
        BasePage.setImplicitlyWait();
        webDriver.get(PAGE);
        indexPage.setAcceptCookies();
    }

    @When("Click on Insights option")
    public void clickOnInsightsOption() {
        indexPage.setLinkInsight();
    }

    @And("Click on Blog option")
    public void clickOnBlogOption() {
        insightPage.setGoToBlog();
    }


    @Then("Validate error of subcription")
    public void validateErrorOfSubcription() {
    }

    @Then("Validate subcription successful")
    public void validateSubcriptionSuccessful() {
    }

    @Then("Print the list of all blog titles")
    public void printTheListOfAllBlogTitles() {
    }

    @And("Find the blog {string}")
    public void findTheBlog(String value) throws InterruptedException {
        blogPage.searchArticle("Why Fintech in Latin America Is Having a Boom");
    }


    @Then("Validate the URL {string}")
    public void validateTheURL(String value) {
        softAssertions.assertThat(value.equals(webDriver.getCurrentUrl()));
    }

    @And("Validate title {string}")
    public void validateTitle(String value) {
        softAssertions.assertThat(value.equals(articlePage.getTitle()));
    }

    @When("Insert the mail {string}")
    public void insertTheMail(String value) {
    }

    @After
    public void end() {
        softAssertions.assertAll();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

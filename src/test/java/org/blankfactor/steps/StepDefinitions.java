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
import org.blankfactor.pageobject.BasePage;
import org.blankfactor.pageobject.IndexPage;
import org.blankfactor.utilities.PropertiesRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("URL");
    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private IndexPage indexPage;
    private Faker faker;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        indexPage = new IndexPage(webDriver);
        softAssertions = new SoftAssertions();
        faker = new Faker();
        webDriver.manage().window().maximize();
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
    public void findTheBlog(String value) {
    }

    @Then("Validate the URL {string}")
    public void validateTheURL(String value) {
    }

    @And("Validate title {string}")
    public void validateTitle(String value) {
    }

    @When("Insert the mail {string}")
    public void insertTheMail(String value) {
    }

    @After
    public void end() {
        //softAssertions.assertAll();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

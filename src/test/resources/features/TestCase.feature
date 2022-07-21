@Execution
Feature: Automation for blankfactor page

  Scenario: Navigate for blog options and validate information
    Given Navigate to blankfactor.com
    When Click on Insights option
    And Click on Blog option
    And Find the blog 'WhyFintechinLatinAmericaIsHavingaBoom'
    Then Validate the URL 'https://blankfactor.com/insights/blog/fintech-in-latin-america/'
    And Validate title 'TechnologyandFinanceAreNoStrangers'

  Scenario: Error on subscribe on newlesster
    Given Navigate to blankfactor.com
    When Click on Insights option
    And Insert the mail 'prueba@prueba.com'
    Then Validate error of subcription

  Scenario: Successful on subscribe on newlesster
    Given Navigate to blankfactor.com
    When Click on Insights option
    And Insert the mail 'prubasblankfactor@gmail.com'
    Then Validate subcription successful

  Scenario: Print list of blog title
    Given Navigate to blankfactor.com
    When Click on Insights option
    And Click on Blog option
    Then Print the list of all blog titles


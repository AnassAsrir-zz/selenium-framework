Feature: Google Search
  AS a user I want to test google search function

  Background: pre-requisites
    Given I open google search page

  Scenario: selenium
    When I lookup the word "selenium"
    Then search results display the word "selenium"

  Scenario: cucumber
    When I lookup the word "cucumber"
    Then search results display the word "cucumber"

  Scenario Outline: <lookup_word>
    When I lookup the word "<lookup_word>"
    Then search results display the word "<expected_result>"
    Examples:
      | lookup_word | expected_result |
      | restassured | restassured     |
      | java        | fail            |

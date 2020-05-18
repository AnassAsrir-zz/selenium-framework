Feature: Google Search
  AS a user I want to test google search function

  Scenario: Basic search
    Given I open google search page
    When I lookup the word "selenium"
    Then search results display the word "selenium"
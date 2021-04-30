@google_search @ui
Feature: Google Search
  AS a user I want to test google search function

  Background: pre-requisites
    Given I open google search page

  @smoke
  Scenario: Basic scenario
    When I lookup the word "selenium"
    Then search results display the word "selenium"

  @ignore
  Scenario Template: <title>
    When I lookup the word "<lookup_word>"
    Then search results display the word "<expected_result>"
    Examples:
      | title                                   | lookup_word | expected_result |
      | Passing scenario using Gherkin keywords | dog         | dog             |
      | Failing scenario using Gherkin keywords | cat         | dog             |

  @keyword
  Scenario Outline: <title>
    Given my data is stored in sheet "<sheet_name>" and row <row_number>
    When I lookup the word
    Then Then search should display the expected results

    Examples:
      | title                                 | sheet_name | row_number |
      | Passing scenario using Excel keywords | Sheet1     | 0          |
      | Failing scenario using Excel keywords | Sheet1     | 1          |
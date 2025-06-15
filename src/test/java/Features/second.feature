Feature: DuckDuckGo Search

  Scenario: 
    Given user is on DuckDuckGo home page
    When user enters "Hello Word"
    And clicks on search button
    Then search results should be displayed

  Scenario: 
    Given user is on DuckDuckGo home page
    When user enters "Java"
    And clicks on search button
    Then java results should be displayed

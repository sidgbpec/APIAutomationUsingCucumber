Feature: reading a repo
  Scenario: authenticated user should be able to read the repo
    Given valid authentication token exist
    And valid repo exist
    When user hit readARepo URL
    Then user should be able to read complete repo
Feature: deleting a repo
  Scenario: authenticated user should be able to delete the repo
    Given a valid authentication token exist
    And a valid repo exist
    When user hit deleteARepo URL
    Then user should be able to delete the repo
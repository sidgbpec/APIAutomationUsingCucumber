Feature: updating a github repository
  Scenario: updating a github repository with valid authenticated token
    Given repo is available i.e. account owner and repo name are available
    And valid authentication token is available
    When user hit update endpoint URL
    Then fields should be updated
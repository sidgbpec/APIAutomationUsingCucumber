Feature: create a github repo for authenticated user
  Scenario: user with valid authentication token should be able to create a github repo
    Given Valid token is there
    When User creates a new github repo
		Then new repo should be created with unique id	
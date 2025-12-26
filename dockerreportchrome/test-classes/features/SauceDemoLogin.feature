@smoke @login @datadriven
Feature: Sauce Demo Login Validation

  Background:
    Given the user navigates to the Sauce Demo login page

  Scenario Outline: Validate login with multiple credential sets
    Given the user enters "<username>" in the username field
    And the user enters "<password>" in the password field
    When the user clicks the login button
    Then the login result should be "<result>"
    And the user should see "<expectedOutcome>"

    Examples:
      | username                  | password       | result   | expectedOutcome                           |
      | standard_user             | secret_sauce   | success  | Products page should be visible            |
      | locked_out_user           | secret_sauce   | failure  | Epic sadface: Sorry, this user is locked out. |
      | problem_user              | secret_sauce   | success  | Products page should be visible            |
      | invalid_user              | wrong_pass     | failure  | Username and password do not match         |
      |                          | secret_sauce   | failure  | Username is required                        |
      | standard_user             |                | failure  | Password is required                        |

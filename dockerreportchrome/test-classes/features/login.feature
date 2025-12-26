Feature: User Login

  Scenario Outline: Verify user can login with valid credentials
    Given User is on the login page
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User should be successfully logged in

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Verify error message with invalid credentials
    Given User is on the login page
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User should see an error message "<errorMessage>"

    Examples:
      | username      | password     | errorMessage                        |
      | invalid_user  | secret_sauce | Username and password do not match |
      | standard_user | invalid_pass | Username and password do not match |

  Scenario: Data driven login test with JSON
    Given User has the test data from "users.json"

    When User tries to login with data row 0
    Then The login should be "successful" for row 0

    When User tries to login with data row 1
    Then The login should be "failed" for row 1

    When User tries to login with data row 2
    Then The login should be "successful" for row 2

    When User tries to login with data row 3
    Then The login should be "successful" for row 3


Feature: Login
  Scenario Outline: Validate Login with Valid users
    Given user on Login page
    When user enter "<username>" and "<password>"
    And user clicks on login
    Then user navigate to inventory page header "<title>"
    Examples:
      | username                | password     | title    |
      | standard_user           | secret_sauce | Products |
      | problem_user            | secret_sauce | Products |
      | performance_glitch_user | secret_sauce | Products |

  Scenario Outline: Validate Login with invalid user
    Given user on Login page
    When user enter "<username>" and "<password>"
    And user clicks on login
    Then user got error "<message>"
    Examples:
      | username | password | message                                                     |
      | admin    | admin    | Username and password do not match any user in this service |

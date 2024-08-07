Feature: Login Functionality
  In order to log in
  As a valid customer
  I want to login successfully

  Background:
    Given Iam in the login page

  Scenario: Login Successfully
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be taken to the Secure Area page

   Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username  | password             | error_message             |
      | tomsmith  | WrongPassword        | Your password is invalid! |
      | wronguser | SuperSecretPassword! | Your username is invalid! |
      |           |                      | Your username is invalid! |

  Scenario: Navigating to the forgotten password page
    When I click on the "Forgotten Password" link
    Then I should be redirected to the password reset page




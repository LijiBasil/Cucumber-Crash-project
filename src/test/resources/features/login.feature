Feature: Login functionality for E-commerce open cart application

  As a user of open Cart application
  I wanted to be logged in with my account
  So that I can access my account privileges

  Background:
    Given I am on the opencart webpage

    Scenario: Login successfully with valid credentials
      Given I have entered valid userName and passWord
      When I click on login button
      Then I have successfully landed the login page

      Scenario Outline: Negative scenarios for invalid credentials
        Given I have entered invalid "<username>" and "<password>"
        When I click on login button
        Then I should see the indicated "<error_message>"
        Examples:
          | username      | password | error_message                |
          | abc@gmail.com | 213123   | Warning: No match for E-Mail Address and/or Password. |
          | 213133213     | @#!##12  | Warning: No match for E-Mail Address and/or Password. |

        Scenario: Nviagating to forgot password page
          Given I click on forgot password link
          Then I should navigate to the forgot password page


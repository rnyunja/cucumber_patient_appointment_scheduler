#Author: Rogers Nyunja
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: CucumberJava
  I want to use this template for my feature file

@tag1
  Scenario: Login Page Comes Up
    Given I have an open browser
    When I enter the login Url
     Then The login page should come up
 

 @tag2
  Scenario: Login Functionality Fails
    Given I enter the login page Url
    And I enter username that is invalid
    When I enter an invalid password
     Then The login button is disabled
    And Login should fail
    #And I get an error message for both and or all fields
    Then Relogin option should be available
    
@tag3
  Scenario: Login Functionality Succeess
    Given I enter the correct Url
    And I enter a valid username
    When I enter a valid password
     Then The login button is enabled
    And Patient Appointment Form should come up

 @tag4
  Scenario Outline: Reset Functionality works
    Given I navigate to login page
    And I enter a username
    When I enter a password
     And I click on reset button
     Then All the fields should clear on the form
    Then User stays on Patient Appointment page
    

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      | name2 |     7 | success |

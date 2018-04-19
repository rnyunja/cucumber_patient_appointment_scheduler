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

Feature: Login Functionality Feature Fail
  In order to ensure I cannot login in,
	If I enter the wrong username and/or password then attemp to log

 @loginFunctionalityFails
  Scenario: Login Functionality Fails
  Given That I have a 'Firefox' browser open
    And I enter login URL, 'http://localhost:8080/PatientAppointmentPage/login.jsp'
    And I enter username that is invalid, like 'patients'
    When I enter an invalid password, like 'patients'
     Then The login button should be enabled
    And Login should fail
    Then Relogin option should be available
    
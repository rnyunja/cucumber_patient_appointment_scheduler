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

Feature: Reset Functionality Feature On Login
  In order to ensure I clear all fields at login,
	If I press on the reset button, all fields should clear

 @positiveScenario
 Scenario: Reset Functionality on Login Succeess
 Given That I have opened a 'Firefox' browser
    And I enter URL for login page, 'http://localhost:8080/PatientAppointmentPage/login.jsp'
    When I enter any username, 'patient'
    And I enter any password, 'patient'
     Then I click on reset button
     Then All the fields on the form should clear 
    And I stay on login page, 'http://localhost:8080/PatientAppointmentPage/login.jsp'
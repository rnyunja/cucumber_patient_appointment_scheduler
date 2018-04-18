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


Feature: Login Page Feature
  In order to ensure Login page comes up,
	I want to run the cucumber test to verify it is working

@positiveScenario
  Scenario: Login Page Comes Up
    Given I open a chrome browser
    When I enter http://localhost:8080/PatientAppointmentPage
     Then The login page http://localhost:8080/PatientAppointmentPage/login.jsp should come up

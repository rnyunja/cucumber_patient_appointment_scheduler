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

Feature: Smoke Test
  In order to ensure the application is up and running,
	I want to go through a set out scenario

@smokeTest
Scenario: Login Page Comes Up
    Given That I open 'Firefox' browser
    When I enter the landing page URL, 'http://localhost:8080/PatientAppointmentPage'
     Then Login page 'http://localhost:8080/PatientAppointmentPage/login.jsp' should come up
	 When I input a valid username, 'patient'
    And I input a valid password, 'passw0Rd'
     Then Login button is enabled and I click
    Then Patient Appointment page 'http://localhost:8080/PatientAppointmentPage/create_patient_appointment.jsp' with a form should come up
    
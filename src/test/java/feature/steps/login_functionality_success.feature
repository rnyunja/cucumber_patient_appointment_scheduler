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

Feature: Login Functionality Feature
  In order to ensure I can login in,
	I want to enter username and password then log in
  
@positiveScenario
  Scenario: Login Functionality Succeess
  Given That I open a 'Firefox' browser
    And I enter login page 'http://localhost:8080/PatientAppointmentPage/login.jsp'
    When I enter a valid username, 'patient'
    And I enter a valid password, 'passwORd'
     And The login button is enabled
     Then I click on login button
    And Patient Appointment Form 'http://localhost:8080/PatientAppointmentPage/create_patient_appointment' should come up

Feature: As user I want to be able to login under different roles
# this is a comment

Scenario: Login as a sales manager
  Given user is on the login page
  When user logs in
  Then user should see dashboard page

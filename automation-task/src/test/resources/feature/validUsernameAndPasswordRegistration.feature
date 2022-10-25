Feature: CRA Registration Page happy testing
  Registration with valid credentials.

  Register with initial credentials to open the register page.
  Test valid data for registration.
  Test invalid data for registration.
  Test Limited version page.

  Scenario: Registration with valid credentials
    When Enter first page username.
    And Enter first page password.
    And Register button is pressed.
    Then Home page is opened.
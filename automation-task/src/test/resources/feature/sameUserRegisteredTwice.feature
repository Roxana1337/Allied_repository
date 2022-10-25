Feature: Registration with the same user twice.

Scenario: Registration not possible when user is already registered.
Given Enter a valid user to be remembered.
And Enter valid password for this user.
When Register button is pressed.
And Press sign out button.
Then Enter same username.
Then Enter same password.
And Register button is pressed.
Then Registration error message is displayed.
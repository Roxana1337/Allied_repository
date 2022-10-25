Feature: Registration with invalid user and valid password.

Scenario Outline: Registration not possible with invalid username and valid password.
When Enter invalid username. <usernameFirst>
And Enter valid password.
And Register button is pressed.
Then Registration error message is displayed.
Examples:
| usernameFirst |
| Us0           |
| user970       |
| USER970       |
| USERWithNoNo  |
|               |
| Ușer9700      |
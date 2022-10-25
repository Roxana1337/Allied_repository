Feature: Registration with valid user and invalid password

Scenario Outline: Registration not possible with valid username and invalid password.
When Enter valid username.
And Enter invalid password. <passwordSecond>
And Register button is pressed.
Then Registration error message is displayed.
Examples:
| passwordSecond |
| Pass1          |
| password1      |
| PASSWORD1      |
| Password       |
|                |
| Pașșword1      |
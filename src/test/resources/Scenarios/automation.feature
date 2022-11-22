Feature: Appium Feature

Scenario Outline: : This is a Test Scenario
  When I enter valid credentials <userName> and <password>
  Then I verify login is completed
  Examples:
    | userName | password |
    | user  | password    |
    | user1 | password1   |

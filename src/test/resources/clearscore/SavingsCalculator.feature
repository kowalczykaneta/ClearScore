Feature: Savings calculator

  Background:User dismisses cookies notification to fully see savings calculator
    Given user opens savings calculator
    Then user dismisses the notification

  Scenario: User adds current score and score goal to see updated current score values.
    Given user set current score to 50  and score goal to 680
    Then user sees updated current score interested rate to 36.5%
    And score costs to 849
    And current cards available to 22

  Scenario: User updates current score and score goal and sees updated score goal values.
    Given user set current score to 50  and score goal to 680
    Then user sees updated score goal interest rate to 25%
    And goal costs to 520
    And goal cards available to 241

  Scenario: User updates current score and score goal and sees updated potential savings.
    Given user set current score to 50  and score goal to 680
    Then user see updated potential savings to 384

Feature: "We use cookies" notification on the main page

  Background: ClearScore main page
    Given user opens ClearScore main page

  Scenario: "We use cookies" notification is present
    Then cookies notification is present


  Scenario: "We use cookies" notification can be dismissed
    Given user dismisses the notification
    Then notification is not present

  Scenario: "We use cookies" notification does not reappear after being dismissed
    When reloads the page
    Then notification is not present

  Scenario: Cookie(s) are set
    Then cookies are set

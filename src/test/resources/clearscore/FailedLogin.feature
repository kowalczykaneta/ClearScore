Feature: Failed login

  Scenario: A failed login returns the correct API response (HTTP 403 error)
    Given user opens ClearScore login page
    When user uses incorrect credentials
    Then returned response is 403 error
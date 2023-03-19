Feature: To validate Registration functionality of application

@login
  Scenario: User validate registration page
    Given User navigates to Register Account page
    When User enters the details into below fields
      |firstName	|Ram					|
      |lastName		|Kanth				|
      |phone number	|1234567890				|
      |email		|ram@xyzcompany.com		|
      |company name |abc infotech           |
    And User selects Role option, company size and responsibility
    And User clicks on submit button
    Then User account should get created successfully

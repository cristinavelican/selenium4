Feature: ContactUs feature
  As a user I am able to send my feedback about the application by filling in my information in a form.


  @contactUs
  Scenario: User fills in personal information and submits feedback
    Given I am on the home page
    When I fill in my information
      |Name|Email|Phone|
      | Cristina  | test@test.com     | +32487454545     |
    And I submit my feedback
      |Subject|Message|
      | I want to submit a test message  | The message I am sending needs to have at least 20 characters    |
    Then I can see the personalized successful message "Thanks for getting in touch"
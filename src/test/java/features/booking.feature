Feature: Book a room

@book
Scenario: Option to book a room is available on the page
Given I am on the home page
When I browse through the page
Then I have the option to book a room

  @book_room_two_nights
  Scenario: Book a room for two available nights
    Given I am on the home page
    When I select the amount of nights and starting date
    |startingDate|numberNights|
    |currentDay|2|
    And I fill in my information
    |Firstname|Lastname|Email|Phone|
    | Cristina  | Test       | test@test.com     | +32487454545     |
    And I book the room
    Then I should be able to successfully book a room

  @unavailable_room
  Scenario: Book a room for two available nights
    Given I am on the home page
    And I also open the website on a different browser window
    When I select the amount of nights and starting date
      |startingDate|numberNights|
      |currentDay|2|
    And I fill in my information
      |Firstname|Lastname|Email|Phone|
      | Cristina  | Test       | test@test.com     | +32487454545     |
    And I book the room
    And I try to book the same room for the same period in the different window
    Then I should see that the period it's unavailable in the second window


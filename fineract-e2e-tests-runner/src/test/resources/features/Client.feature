@ClientFeature
Feature: Client

  @TestRailId:C14 @Smoke
  Scenario Outline: Client creation functionality for Fineract
    When Admin creates a client with Firstname <firstName> and Lastname <lastName>
    Then Client is created successfully
    Examples:
      | firstName    | lastName |
      | "FirstName1" | "Test1"  |
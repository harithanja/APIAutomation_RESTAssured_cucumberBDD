Feature: Adding a place to the API
  @AddPlace
  Scenario Outline: Add place Successfully
    Given Create a request payload with "<sheet>" and <row>
    When user calls  resource with http "POST" request
    Then  validate the Response Time


    Examples:
      |sheet|row|
      |Sheet1   |1        |
      |Sheet1   |2        |
      |Sheet1   |3        |
      |Sheet1   |4        |
      |Sheet1   |5        |
      |Sheet1   |6        |
      |Sheet1   |7        |
Feature: Fetching a place from the API
      @back
  Scenario Outline: Fetch the place Successfully
    Given Create  request payload with "<sheet>" and <row> for GET
        When user calls  resource with http "GET" request
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


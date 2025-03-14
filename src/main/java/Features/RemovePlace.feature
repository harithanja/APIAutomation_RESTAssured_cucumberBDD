Feature: Deleting a place from the API
  @remove
  Scenario Outline:delete the place Successfully
    Given Create request payload with "<Sheet>" and <row> to delete
    When user calls  resource with http "DELETE" request
    Then  validate the Response Time


    Examples:
      | Sheet | row |
      |Sheet2   |1        |
      |Sheet2   |2        |
      |Sheet2   |3        |
      |Sheet2   |4        |
      |Sheet2   |5        |
      |Sheet2   |6        |
      |Sheet2   |7        |
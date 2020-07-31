Feature: Select city for tour 2

  Scenario Outline: Slide and select city from dash board
    Given Session is started
    When Started with dash board
    Then Slide and click on the <City> block
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
#    | GOA       |
#    | MUMBAI    |
#    | New Delhi |
    | KOLKATA   |
    
    
  Scenario Outline: Select city from All Cities search
    Given Session is started
    When Started with dash board
    Then Scroll to Name button and click on it
    | Name | see all cities |
    And Type <City> inside the search edit
    And Verify the search results for <City>
    And Select the best matched search result
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
#    | GOA       |
#    | MUMBAI    |
#    | New Delhi |
    | KOLKATA   |
    
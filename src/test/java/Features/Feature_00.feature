Feature: Select city for tour 1

  Scenario Outline: Slide and select city from dash board
    Given Session started on Device
    | Device | emulator-5554 |
    When Started with dash board
    Then Slide and click on the <City> block
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | KOLKATA   |
    
    
  Scenario Outline: Select city from All Cities search 1
    Given Session started on Device
    | Device | emulator-5556 |
    When Started with dash board
    Then Scroll to Button and click on it
    | Button | see all cities |
    And Type <City> inside the search edit
    And Verify the search results for <City>
    And Select the best matched search result
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | New Delhi |
    
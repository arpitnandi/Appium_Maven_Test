Feature: Select city for tour 2

  Scenario Outline: Slide and select city from dash board
    Given Session started on Device
    | Device | emulator-5558 |
    When Started with dash board
    Then Slide and click on the <City> block
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | MUMBAI    |
    
    
  Scenario Outline: Select city from All Cities search 2
    Given Session started on Device
    | Device | emulator-5554 |
    When Started with dash board
    Then Scroll to Button and click on it
    | Button | SEE ALL CITIES |
    And Type <City> inside the search edit
    And Verify the search results for <City>
    And Select the best matched search result
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | GOA       |
    
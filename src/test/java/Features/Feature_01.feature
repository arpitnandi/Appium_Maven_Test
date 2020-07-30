Feature: Select city for tour 2

  Scenario Outline: Slide and select city from dash board
    Given Session is started
    | URL             | http://localhost:4723/wd/hub                                        |
    | platformName    | Android                                                             |
    | automationName  | UiAutomator2                                                        |
    | platformVersion | 5.1.1                                                               |
    | udid            | emulator-5554                                                       |
    | app             | C:\Users\Admin\eclipse-workspace\Appium_Test00\cleartrip_19.2.1.apk |
    | appWaitActivity | com.cleartrip.android.common.activities.CleartripHomeActivity       |
    When Started with dash board
    Then Slide and click on the <City> block
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | GOA       |
    | MUMBAI    |
    | New Delhi |
    | KOLKATA   |
    
    
  Scenario Outline: Select city from All Cities search
    Given Session is started
    | URL             | http://localhost:4723/wd/hub                                        |
    | platformName    | Android                                                             |
    | automationName  | UiAutomator2                                                        |
    | platformVersion | 5.1.1                                                               |
    | udid            | emulator-5554                                                       |
    | app             | C:\Users\Admin\eclipse-workspace\Appium_Test00\cleartrip_19.2.1.apk |
    | appWaitActivity | com.cleartrip.android.common.activities.CleartripHomeActivity       |
    When Started with dash board
    Then Scroll to Name button and click on it
    | Name | SEE ALL CITIES |
    And Type <City> inside the search edit
    And Verify the search results for <City>
    And Select the best matched search result
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City      |
    | GOA       |
    | MUMBAI    |
    | New Delhi |
    | KOLKATA   |
    
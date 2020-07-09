#Author: "arpitnandi1@gmail.com"

#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#"" (String Value)
## (Comments)


Feature: Select city for tour

  Scenario Outline: Slide and select city from dash board
    Given Session is started
    | URL             | http://localhost:4723/wd/hub                                 |
    | platformName    | Android                                                      |
    | automationName  | UiAutomator2                                                 |
    | platformVersion | 10.0                                                         |
    | deviceName      | Pixel_XL_API_29                                              |
    | app             | D:\Git_Share\Appium_Test00\Android.Test\cleartrip_19.2.1.apk |
    | appPackage      | com.cleartrip.android                                        |
    | appWaitActivity | com.cleartrip.android.activity.common.SplashActivity         |
    When Started with dash board
    Then Slide and click on the <City> block
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City    | Name           |
    | GOA     | SEE ALL CITIES |
    | MUMBAI  | SEE ALL CITIES |
    | KOLKATA | SEE ALL CITIES |
    
    
  Scenario Outline: Select city from All Cities search
    Given Session is started
    | URL             | http://localhost:4723/wd/hub                                 |
    | platformName    | Android                                                      |
    | automationName  | UiAutomator2                                                 |
    | platformVersion | 10.0                                                         |
    | deviceName      | Pixel_XL_API_29                                              |
    | app             | D:\Git_Share\Appium_Test00\Android.Test\cleartrip_19.2.1.apk |
    | appPackage      | com.cleartrip.android                                        |
    | appWaitActivity | com.cleartrip.android.activity.common.SplashActivity         |
    When Started with dash board
    Then Scroll to <Name> button and click on it
    And Type <City> inside the search edit
    And Verify the search results for <City>
    And Select the best matched search result
    And Verify the name of the selected <City>
    And Navigate back to the dash board
    And Close the application
       
    Examples:
    | City    | Name           |
    | GOA     | SEE ALL CITIES |
    | MUMBAI  | SEE ALL CITIES |
    | KOLKATA | SEE ALL CITIES |
    
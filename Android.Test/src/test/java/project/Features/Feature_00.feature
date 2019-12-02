#Author: "arpitnandi1l@gmail.com"
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given Open App with following configurations
    | URL                  | http://localhost:4723/wd/hub        |
		| platformName         | Android                             |
		| platformVersion      | 8                                   |
		| deviceName           | Pixel_XL_API_26                     |
		| appPath              | D:\Download                         |
		| app                  | Cleartrip_com.cleartrip.android.exe |
		| automationName       | UiAutomator2                        |
		| autoGrantPermissions | true                                |
		 
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

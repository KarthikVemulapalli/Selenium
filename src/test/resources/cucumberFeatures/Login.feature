Feature: OrangeHRM Application Login

Background:
	Given BrowserName
	When Browser is trigerred
	Then Validate browser title

@RegTest
Scenario: Application Login
	Given User is on Home Page
	When User login to application using credentials "Username" and "Password"
	Then AccountID 123 page is displayed
	And Validate account page title
	
@SmokeTest
Scenario: Application Login Using Parameters
	Given User is on Home Page
	When User login to application using credentials "NewUsername" and "NewPassword"
	Then AccountID 321 page is displayed
	And Validate account page title
	
@RegTest @SmokeTest
Scenario: Application Login Using DataTable Concept
	Given User is on Home Page
	When User SignUp into application using following data
	| UserName | DOB | Email | Password |
	Then AccountID 123456 page is displayed
	And Validate account page title
	
@SanityTest
Scenario Outline: Application Login Using Multiple Data Parameterization Concept
	Given User is on Home Page
	When User login to application using credentials <Username> and <Password>
	Then AccountID <AccountID> page is displayed
	And Validate account page title

	Examples:
	| Username | Password | AccountID |
	| "User1" | "Pass1" | 001 |
	| "User2" | "Pass2" | 002 |
	| "User3" | "Pass3" | 003 |
	| "User4" | "Pass4" | 004 |
	
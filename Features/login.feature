Feature: Login to the website

@SmokeTest
  Scenario: Validate if the guest user is able to login to the website.
    Given open browser
    When enter URL
    And Click on My Account Tab
    And Enter Username
    And Enter Password
    And Click on the login button
    Then user succesfully logins to My Account
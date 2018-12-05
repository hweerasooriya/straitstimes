Feature: Reading the main article on straitstimes site
      As a reader of the straitstimes Online site
      I want to login my reader profile using my credentials
      In order to login with credentials
 Background: User navigates to straitstimes main page

  Scenario: verify successful login and the header of straitstimes
    Given user launch the chrome browser
    When user load straitstimes
    When user clicks on login link
    When user enters valid sign in details
            |loginID               |password   |
            |digitaltest2          |Sphdigital1|
    When user clicks on "Sign in" button in login page
    Then user should be able to see username "digitaltest2" in home page header
    Then user close the browser

  Scenario: verify the main article consists image/video
    Given user launch the chrome browser
    When user load straitstimes
    When user clicks on login link
    When user enters "digitaltest2" for loginID
    When user enters "Sphdigital1" for password
    When user clicks on sign in link
    When user navigates main article page
    Then user should be able to see main article with image/video
    Then user close the browser


   Scenario: verify the user can view the main article page
     Given user launch the chrome browser
     When user load straitstimes
     When user clicks on login link
     When user enters "digitaltest2" for loginID
     When user enters "Sphdigital1" for password
     When user clicks on sign in link
     When user navigates main article page
     Then user should be able to see main article with image/video
     When user click on the main article
     And user navigate to the main article page with image/video
     Then user close the browser
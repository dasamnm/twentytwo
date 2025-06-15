Feature: Facebook Login

  @smoke
  Scenario: Login With Valid Credentials
    Given user is on login page
    When user enters username "<sagar2kankam@gmail.com>"
    And password "<wineganga>"
    And clicks on login button
    Then profile page should be displayed

  Scenario Outline: Login With Invalid Credentials
    Given user is on login page
    When user enters username "<username>"
    And password "<password>"
    And clicks on login button
    Then "The password that you've entered is incorrect." error message should be displayed

    Examples: 
      | username                  | password      |
      | sagar2kankam@gmail.com    | wineganga     |
      | sagardg2kankam@gmail.com  | dgsddfgddfgsd |
      | sagar2dfgkankam@gmail.com | cvxbvcbsd     |
      | sagar2kankam@gdfgmail.com | cxvbbcxgsdgsd |
      | sagar2kdfgankam@gmail.com | fghsdgsd      |

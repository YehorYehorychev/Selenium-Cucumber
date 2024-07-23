Feature: Application login

  Background:
    Given Setup the entries in database
    When Launch the browser from config variables
    And Hit the home page url of banking site

  @RegressionTest
  Scenario: Admin page default login

    Given User is on NetBanking landing page
    When User login into application with "admin" and password "1234"
    Then Home Page is displayed
    And Cards are displayed

  @MobileTest
  Scenario: User page default login

    Given User is on NetBanking landing page
    When User login into application with "user" and password "8878"
    Then Home Page is displayed
    And Cards are displayed

  @RegressionTest
  Scenario Outline: User page default login

    Given User is on NetBanking landing page
    When User login into application with "<Username>" and password "<Password>" combination
    Then Home Page is displayed
    And Cards are displayed

    Examples:
      | Username   | Password |
      | debituser  | hello123 |
      | stockuser  | stok3453 |
      | credituser | lpo7474  |

  @SmokeTest @RegressionTest
  Scenario: User page default Sign Up

    Given User is on Practice landing page
    When User Signup into application
      | yehor         |
      | yehorychev    |
      | egor@test.com |
      | 6506564655    |
    Then Home Page is displayed
    And Cards are displayed


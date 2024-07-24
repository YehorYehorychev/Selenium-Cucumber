Feature: Application login

  Background:
    Given Setup the entries in database
    When Launch the browser from config variables
    And Hit the home page url of banking site


  @MobileTest @NetBanking
  Scenario: User page default login

    Given User is on NetBanking landing page
    When User login into application with "user" and password "8878"
    Then Home Page is displayed
    And Cards are displayed

  @SmokeTest @RegressionTest
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
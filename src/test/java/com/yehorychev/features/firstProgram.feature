Feature: Application login

  Scenario: Admin page default login

    Given User is on NetBanking landing page
    When User login into application with "admin" and password "1234"
    Then Home Page is displayed
    And Cards are displayed

  Scenario: User page default login

    Given User is on NetBanking landing page
    When User login into application with "user" and password "8878"
    Then Home Page is displayed
    And Cards are displayed
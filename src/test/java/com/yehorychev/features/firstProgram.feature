Feature: Application login

  Scenario: Admin page default login

    Given User is on NetBanking landing page
    When User login into application
    Then Home Page is displayed
    And Cards are displayed

  Scenario: User page default login

    Given User is on NetBanking landing page
    When User login into application
    Then Home Page is displayed
    And Cards are displayed
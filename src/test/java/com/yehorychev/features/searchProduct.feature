Feature: Search and place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both Home page and Offers page

    Given User is on GreenKart Landing page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And Validate product name in Offers Page matches with Landing Page

    Examples:
    | Name       |
    | Tomato     |
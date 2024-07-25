Feature: Search and place the order for Products

  Scenario: Search Experience for product search in both Home page and Offers page

    Given User is on GreenKart Landing page
    When User searched with shortname "Tom" and extracted actual name of product
    Then User searched for "Tom" shortname in offers page
    And Validate product name in Offers Page matches with Landing Page
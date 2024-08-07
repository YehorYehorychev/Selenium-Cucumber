Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Search and Checkout Experience for product search in both Home page and Offers page

    Given User is on GreenKart Landing page
    When User searched with shortname <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And Verify that the user has ability to enter promo code and place the order

    Examples:
    | Name       |
    | Tomato     |
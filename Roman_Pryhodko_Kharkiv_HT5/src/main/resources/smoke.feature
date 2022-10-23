Feature: Smoke
  As a user I want to use
  Functionality of website

  Scenario Outline: Check log in
    Given User opens '<homePage>' page
    And User checks log in button visibility
    And User clicks on log in button
    When User enters '<email>' and '<password>'
    And User clicks on sign in button
    Then User logs into his account

    Examples:
      | homePage              | email             | password            |
      | https://www.ebay.com/ | pomahic@gmail.com | seleniumTestPass123 |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User logs in
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | keyword  | amountOfProducts |
      | https://www.ebay.com/ | WW2 book | 1                |

  Scenario Outline: Check log in with invalid data
    Given User opens '<homePage>' page
    And User checks log in button visibility
    And User clicks on log in button
    When User enters '<email>'
    And User clicks on continue button
    Then User sees an error message

    Examples:
      | homePage              | email        |
      | https://www.ebay.com/ | dfghjkgbhnjk |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User logs in
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks Add to cart button
    And User clicks on Cart button
    Then User checks that amount of products in cart are '<amountOfProducts>'
    And User removes product from cart

    Examples:
      | homePage              | keyword  | amountOfProducts |
      | https://www.ebay.com/ | WW2 book | 1                |

  Scenario Outline: Check filter on results page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on Brand filter checkbox
    And User clicks on first product
    Then User checks that this product matches the filter

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | shoe    |

  Scenario Outline: User adds seller to saved
    Given User opens '<homePage>' page
    And User logs in
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks on Save this seller button
    And User opens '<homePage>' page
    And User clicks on Saved button
    Then User checks that seller added

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | hat     |

  Scenario Outline: User removes seller from saved
    Given User opens '<homePage>' page
    And User logs in
    When User clicks on Saved button
    And User selects a saved merchant they want to remove
    And User clicks on remove button
    And User opens '<homePage>' page
    And User clicks on Saved button
    Then User checks that seller removed

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: User checks search result customize
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on customize button
    And User clicks on item number option
    And User apply settings
    Then User checks that products have info about item number

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | hat     |

  Scenario Outline: User checks auction products filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks auction button
    And User clicks on first product
    Then User can enjoy auction
    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | hat     |

  Scenario Outline: User using search, but forgot switch keyboard layout language
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User does not find anything
    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | шзрщту  |
#loginPage https://www.ebay.com/signin/
#profile page https://www.ebay.com/usr/pom7241
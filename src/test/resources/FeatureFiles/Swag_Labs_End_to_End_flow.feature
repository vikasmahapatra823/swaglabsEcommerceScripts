Feature: Swags Lab Login functionality


  @Test
  Scenario: To Verify Login of Ecommerce Website
    Given Navigate to the "SWAGS LABS" Ecommerce Website
    And Login to the Ecommerce Website as "Standard User"
    And Click on the item "Sauce Labs Backpack"
    And Verify the Page Header is "Swag Labs"
    And Wait for "2" seconds
    Then Verify the product item is "Sauce Labs Backpack"
    And Verify the product item description is "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And Get the Inventory item price details "Sauce Labs Backpack"
    And Click on the "Add to cart" button
    And Click on the Shopping cart icon on the top right corner
    And Verify the Price band of "Sauce Labs Backpack"
    And Wait for "3" seconds
    And Click on the "Checkout" button
    And Wait for "3" seconds
    And Verify the Page Header is "Checkout: Your Information"
    And Fill the below data
      | Field Name      | Value  |
      | First Name      | TestfN |
      | Last Name       | TestlN |
      | Zip/Postal Code | 23010  |
    And Click on the "Continue" button
    And Verify the Page Header is "Checkout: Overview"
    And Wait for "5" seconds
    And Click on the "Finish" button
    And Verify the Page Header is "Checkout: Complete!"
    And Verify the text: "Thank you for your order!"
    And Verify the text: "Your order has been dispatched, and will arrive just as fast as the pony can get there!"


  @Test_01
  Scenario: Verify Adding Multiple Product Items into Cart
    Given Navigate to the "SWAGS LABS" Ecommerce Website
    And Login to the Ecommerce Website as "Standard User"
    Then Verify the product item is "Sauce Labs Backpackaa"
    And Add the Following Product into the Cart:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And Click on the Shopping cart icon on the top right corner
    And Click on the "Checkout" button
    And Fill the below data
      | Field Name      | Value  |
      | First Name      | TestfN |
      | Last Name       | TestlN |
      | Zip/Postal Code | 23010  |
    And Click on the "Continue" button
    And Verify the Page Header is "Checkout: Overview"
    And Wait for "5" seconds
    And Click on the "Finish" button
    And Verify the Page Header is "Checkout: Complete!"
    And Verify the text: "Thank you for your order!"
    And Verify the text: "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
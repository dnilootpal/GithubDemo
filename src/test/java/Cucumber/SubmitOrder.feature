
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

Background: 
 		Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given I logged in with username "<username>" and password "<password>"
    When I add product "<productName>" to Cart
    And Checkout product "<productName>" and submit the order
    Then I verify the message "THANKYOU FOR THE ORDER." is displayed on Confirmation page

    Examples: 
      |username| password|productName|
      |dnilootpal@gmail.com|Nilu@310596|ZARA COAT 3|


@tag
Feature: Error validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When I logged in with username "<username>" and password "<password>"
    Then Verify "Incorrect email or password." message is displayed

    Examples: 
      |username| password|
      |dnilootpal@gmail.com|abcNilu@310596|

#Author: bishnupriya.m@synechron.com

Feature: User login as Customer

    
@Customer
  Scenario Outline: Customer Login and Logout
   Given User is on home Page
    When User clicks on Customer Login 
    Then User Selects "<name>" and clicks Login
    Then It will "<display>" User Name and Account Details
    When User clicks Logout
    Then It will go back to user select page
    Then User clicks on home and land on Home Page

  Examples: 
      | name  | display |
      | Hermoine Granger | Hermoine Granger | 
      | Harry Potter |  Harry Potter | 
  
   


   
   
    
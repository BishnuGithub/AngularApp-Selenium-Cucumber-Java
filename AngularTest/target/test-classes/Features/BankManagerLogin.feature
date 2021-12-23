#Author: bishnupriya.m@synechron.com

Feature: Bank Manager features
 
 
  @BankManager
  Scenario: Bank manager Login and exit
   Given User is on Home Page
    When User clicks on Bank manager Login
    Then User lands on bank manager Page with Add Customer , Open Account , Customers buttons available  
    When User clicks on home and will land on Home Page
    
  
       
  

Feature: Bigbasket Functionality

Scenario: TC004_BigBasketFunctionality
Given Go to bigbasket
And Hover Shop by Category
And Go to Foodgrains, oil,rice
And get url and check
And choose Brand
And Go to Ponni and selectqty and add
And Search dal
And Add toor dhal and set Qty 
And Enter Address
When Hover Mybasket and screenshot
Then View Basket and checkout

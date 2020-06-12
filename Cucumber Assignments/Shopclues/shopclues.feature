Feature: Shopclues Functionality

Scenario Outline: TC005_Shopclues
Given Go to shopclues
And Mouseover on women and click Casual Shoes
And Select Color as Black
And Check whether the product name contains the word black
And If so, add the product name and price in to Map
And Check Display the count of shoes which are more than <price> rupees
And Click the highest price of the shoe
And et the current page URL and check with the product ID
And Copy the offercode 
And Select size, color and click ADD TO CART
When Mouse over on Shopping cart and click View Cart 
Then Pincode as <pin> click Submit and Place Order 
And  Close the Browser
Examples:
|price|pin|
|500|600016|
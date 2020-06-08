Feature: Carwale functionality

Scenario: TC001_CarwaleFunctionality
Given Go to carwale
And Click on Used   
And Select the City as Chennai  
And Select budget and Click Search     
And Select Cars with Photos under Only Show Cars With
And Select Manufacturer as Hyundai 
And Select Fuel Type as Petrol 
And Select Best Match 
And Validate the Cars are listed with KMs Low to High  
And Add the least KM ran car to Wishlist 
And Go to Wishlist and Click on More Details 
When Print all the details under Overview in the Same way as displayed in application 
Then Close the browser. 
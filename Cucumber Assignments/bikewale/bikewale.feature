Feature: Bikewale_Functionality

Scenario: TC0012_Bikewale_Scenario
Given Go to menu and click new bikes
And Click New Bikes Then compare bikes
And Add first bike as Royal Enfield and model as Thunderbird 350
And Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI
And  Add bike brand Kawasaki model as Ninja 300
When click compare
Then Find and print the maximum overall rating of all the bikes and find the max
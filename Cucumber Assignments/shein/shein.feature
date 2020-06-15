Feature: Shein Functionality

Scenario: TC006_Test Shein Functionality
Given Go to shein
And  Hover on Clothing and jeans
And Choose Black under Jeans product count
And check size as medium
And check whether the color is black 
And Click first item to Add to Bag
And Click the size as M abd click Submit
And Click view Bag 
When Check the size is Medium or not.
Then close the shein browser



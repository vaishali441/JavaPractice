Feature: JustDial Functionality

Scenario Outline: TC009_Justdial scenario
Given Cick on Air Tickets
And Type Chennai and choose Chennai, IN - Chennai Airport (MAA) as Leaving From 
And Type Toronto and select Toronto, CA - Toronto City Centre Airport (YTZ) as Going To 
And Set Departure
And Add Adult <adult>, Children <child> click and Search
And Select Air Canada from multi-airline itineraries
And Click on Price to sort the result
And Click on +Details of first result under Price
And Capture the Flight Arrival times.
And Capture the total price in a list and Click on Book
When Capture the Airport name base on the list of time
Then Captur the total fare and print the difference amount from previous total price
Examples:
|adult|child|
|2|1|

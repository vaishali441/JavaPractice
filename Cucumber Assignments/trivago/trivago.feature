Feature: Trivago Application functionality

Scenario: TC002_RoomBooking in Trivago
Given Go to trivago
And Type Agra in Destination and select Agra, Uttar Pradesh
And choose checkin and checkout date
And Select roomtype
And choose Adults_children
And click confirm and search
And Select accomdation type
And select guest rating
And select Airconditioning
And sort the results
And Print hotelname and rating
And print URL
And print room price
When click reserve
Then close the browser

 

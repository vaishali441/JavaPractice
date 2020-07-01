Feature: Lenskart Feature

Scenario Outline: TC0013_Lenskart Scenario
Given Mouseover on Contact Lenses 
And  Click on Monthly under Explore By Disposability
And Select brand as Aqualens
And Click on the first product
And Click Buy Now
And Select No of boxes as <noofbox> and Power as <power> for both eyes.
And Type your name in User's name 
And And click Save and continue
And  Print total amount and click Proceed to Checkout
And  Click Add to Bag and click on FREE DELIVERY & RETURNS* on the top of the page
And Click on Start chat in the Start chat and go to the new window
When Enter you first name and a dummy email and click Start Chat
Then Type Hi, click Send and print thr reply message and close the chat window.

Examples:
|noofbox|power|
|2|-1|
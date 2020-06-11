Feature: Ajio Functionality

Scenario: TC003_Ajio_Functionality
Given Go to Ajio
And WomenCategory_kurtas
And Brand Ajio
And ajio results
And sort result as discount
And Select color and Add to Bag
And Verify error message
And select size and add to bag
And enter pincode
And confirm pincode
When Print message and go to bag
Then Proceed to Shipping and close browser

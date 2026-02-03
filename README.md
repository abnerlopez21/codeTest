  ExampleInstrumentedTest file has 4 test.
checkoutFlow() test is the most complete one.

Given I am logged in as a Standard User
When I add products to the cart
  And I navigate to the Cart screen
  And I complete the checkout form with my data
  And I click on Continue
  And I click on Finish
Then I should be redirected to the Checkout Complete screen
When I click on Back Home
Then I should be redirected to the Home Page


BaseTestUi contains all the steps behind the Tests.
Interactors file has all the strings and elements needed for the tests.

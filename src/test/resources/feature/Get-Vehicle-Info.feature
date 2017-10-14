Feature: Vehicle Information

@sanity
Scenario: Get Vehicle Information
Given User navigate to the DVLA Vehicle Information Home Page
When Verify Home page title
And User click on Start button from DVLA Home Page
Then User enter Registration No
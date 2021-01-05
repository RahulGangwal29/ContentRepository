Feature: Content validation for KPS website (English)

 Scenario: Content Validation Check
    Given User launches the driver and naviagtes to the website
    When user is on home page and fetches the content of the page
    And user navigates to the our firm page and fetches the content of the page
    And user navigates to the our projects page and fetches the content of the page 
    And user navigates to the our services page and fetches the content of the page
    And user navigates to the insights page and fetches the content of the page
    And user navigates to the contact us page and fetches the content of the page
    Then validate whether the content present is expected client content

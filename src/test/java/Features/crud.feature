Feature: Create read update and delete
"""
  Test Cases Covered:
  1. Navigate to crud contact information home and validate landing page
  2. Create new contact information and verify added data
  3. Read table field names and data values
  4. Update an existing data and verify correctness
  5. Delete all existing contact information from table

"""

# Scripts covered:
#   1. Navigate to crud contact information home and validate landing page
#   2. Create new contact information and validate added data
# Pre-requisites: NA
# Batch Tag
  @crud
#Case Tag
  @CreateNewContactInfo
  Scenario Outline: Validate user is able to create new contact information
    Given User navigates to website homepage
    When User navigated to contact information read window page
    Then User should be able to see contact information read page
    When User creates new contact information using "<id>", "<name>", "<email>", "<phone>" and "<title>"
    Then User should be able to view added contact information

    Examples:
      | id | name             | email              | phone  | title             |
      | 2  | Deadpool         | deadpool@test.com  | 123456 | Comedian          |
      | 3  | Wolverine        | wolverine@test.com | 124655 | Renewed Contract  |
      | 4  | Scarlet Witch    | witch@test.com     | 178539 | Buried            |
      | 5  | Iron Man         | ironman@test.com   | 145866 | Dr. Doom          |
      | 6  | Captain America  | capt@test.com      | 124557 | Human Torch only  |
      | 7  | The Hulk         | hulk@test.com      | 127537 | Big comedian guy  |
      | 8  | Vision           | vision@test.com    | 134357 | No more           |
      | 9  | SpiderMan        | spidey@test.com    | 756336 | The Forgotten     |
      | 10 | Doctor Strange   | strange@test.com   | 139676 | Cannot do the job |
      | 11 | Black Widow      | strange@test.com   | 423536 | The Fallen        |


# Scripts covered:
#   1. Navigate to crud contact information home and validate landing page
#   2. Verify if read page is visible
#   3. Verify is user can read data in contact information table
# Pre-requisites: NA
# Batch Tag
  @crud
#Case Tag
  @ReadContactInfo
  Scenario: Validate user is able to read expected data in contact information table
    Given User navigates to website homepage
    When User navigated to contact information read window page
    Then User should be able to see contact information read page
    And User verify existing contact information


# Scripts covered:
#   1. Navigate to crud contact information home and validate landing page
#   2. Update an existing contact information and validate modified data
# Pre-requisites: Table has existing data
# Batch Tag
  @crud
#Case Tag
  @UpdateContactInfo
  Scenario Outline: Validate user is able to update existing data in contact information table
    Given User navigates to website homepage
    When User navigated to contact information read window page
    Then User should be able to see contact information read page
    And User verify existing contact information
    When User updates an existing contact information using "<id>", "<name>", "<email>", "<phone>" and "<title>"
    Then User should be able to view the modified contact information

    Examples:
      | id | name         | email            | phone   | title            |
      | 2  | Updated Name | updated@test.com | 6890381 | Senior Developer |


# Scripts covered:
#   1. Navigate to crud contact information home and validate landing page
#   2. Deletes all existing contact information and verifies if table is empty
# Pre-requisites: NA
# Batch Tag
  @crud
#Case Tag
  @DeleteAllContactInfo
  Scenario: Validate user is able to delete data in contact information table
    Given User navigates to website homepage
    When User navigated to contact information read window page
    Then User should be able to see contact information read page
    And User verify existing contact information
    Then User deletes existing contact information

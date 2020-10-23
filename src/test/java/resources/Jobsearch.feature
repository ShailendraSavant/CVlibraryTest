Feature: I want to apply for a job

  @CVJobSearchTest
Scenario Outline: I want to search for job on CV-Library website
  Given I am on CV Library website and i select more search option
  When  I enter "<Keyword>" "<Location>" "<select_miles>" "<Salary_Min>" "<Salary_Max>" "<Salary_Type>" "<Job_Type>"
  And   I select Find Jobs
  Then  I can see all jobs
Examples:
|Keyword      | Location |select_miles| Salary_Min| Salary_Max| Salary_Type| Job_Type|
| Test Manager| London   |50          |40000      | 50000     |Per annum   |Permanent|



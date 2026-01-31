/*
  pb32_CountSalaryCategories.sql

  Problem summary:
  - Given an `Accounts` table with at least an `income` column,
    categorize accounts into three salary buckets and count how many fall
    into each category:
    * High Salary: income > 50000
    * Low Salary: income < 20000
    * Average Salary: income between 20000 and 50000 (inclusive)

  Why UNION ALL instead of UNION?
  --------------------------------
  - UNION removes duplicate rows and sorts results (performance overhead).
  - UNION ALL keeps all rows and is faster (no deduplication/sorting).
  - Since each SELECT generates exactly 1 row (one count per category),
    there are no duplicates to remove. Using UNION ALL avoids wasted effort
    and is the correct choice here.
  - This query produces exactly 3 rows (one per category), so UNION vs
    UNION ALL makes no logical difference, but UNION ALL is more efficient.
*/

-- Query 1: Count accounts with HIGH SALARY (income > 50000)
SELECT
    'High Salary' AS category,
    COUNT(CASE WHEN income > 50000 THEN 1 END) AS accounts_count
FROM 
    Accounts

UNION ALL

-- Query 2: Count accounts with LOW SALARY (income < 20000)
SELECT
    'Low Salary' AS category,
    COUNT(CASE WHEN income < 20000 THEN 1 END) AS accounts_count
FROM 
    Accounts

UNION ALL

-- Query 3: Count accounts with AVERAGE SALARY (20000 <= income <= 50000)
SELECT
    'Average Salary' AS category,
    COUNT(CASE WHEN income BETWEEN 20000 AND 50000 THEN 1 END) AS accounts_count
FROM 
    Accounts

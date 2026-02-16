-- This SQL query retrieves the name and salary of employees from the Employees table and categorizes their salary into three ranges: 'Low', 'Medium', and 'High'. The CASE operator is used to determine the salary range based on the value of the salary column. The results are ordered by the employee's name.
SELECT
    name, salary,
    CASE
        WHEN salary < 30000 THEN 'Low'
        WHEN salary >= 30000 AND salary < 70000 THEN 'Medium'
        ELSE 'High'
    END AS SalaryRange
FROM
    Employees
ORDER BY
    name;

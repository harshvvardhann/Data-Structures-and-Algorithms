-- Problem: Find the top 3 highest salaries in each department

/*
  Solution 1: Using Window Functions (Recommended)
  - Uses DENSE_RANK() to assign a rank to each employee within their department based on salary.
  - DENSE_RANK() is chosen over RANK() because if multiple employees have the same salary,
    they share the same rank, and the next rank is consecutive (e.g., 1, 1, 2).
*/
SELECT 
    Department, 
    Employee, 
    Salary
FROM
    (
        SELECT 
            d.name AS Department,
            e.name AS Employee,
            e.salary AS Salary,
            -- Partition by department to rank within each group independently
            -- Order by salary descending to give rank 1 to the highest salary
            DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS rnk
        FROM
            Employee e
        JOIN
            Department d
        ON
            e.departmentId = d.id
    ) t
WHERE
    rnk <= 3; -- Filter to keep only the top 3 ranks


/*
  Solution 2: Using Self-Join and Group By (Alternative/Legacy approach)
  - Logic: An employee is in the top 3 if there are fewer than 3 distinct salaries 
    greater than their own salary within the same department.
  - e.g., If 0 people earn more -> Rank 1.
  -       If 1 person earns more -> Rank 2.
  -       If 2 people earn more -> Rank 3.
*/
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM
    Employee e
JOIN
    Department d
ON 
    e.departmentId = d.id
LEFT JOIN
    Employee e2
ON 
    e.departmentId = e2.departmentId -- Match same department
AND
    e2.salary > e.salary             -- Find employees earning MORE than 'e'
GROUP BY
    d.name, e.name, e.salary
HAVING 
    -- Count how many distinct higher salaries exist.
    -- If count is 0, 1, or 2, then 'e' is in the top 3.
    COUNT(DISTINCT e2.salary) < 3
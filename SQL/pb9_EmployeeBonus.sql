-- SQL query to find the names of employees who received a bonus less than 1000 or did not receive any bonus at all.

SELECT 
    e.name, b.bonus 
FROM 
    Employee e 
LEFT JOIN 
    Bonus b 
ON 
    e.empId = b.empId 
WHERE 
    b.bonus < 1000 
OR 
    b.bonus 
IS NULL
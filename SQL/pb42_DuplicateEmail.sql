# Write your MySQL query statement below

-- Problem: Delete duplicate emails from the Person table
-- Goal: Keep only the unique email with the smallest ID
-- Approach: Self-join the table to find pairs of rows with the same email

DELETE p1
FROM 
    Person p1
JOIN
    Person p2
ON
    p1.email = p2.email -- Condition 1: Emails match
AND     
    p1.id > p2.id       -- Condition 2: p1's ID is greater than p2's ID (delete the larger one)

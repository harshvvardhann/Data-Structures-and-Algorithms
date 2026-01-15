-- SQL query to find the names of customers whose referee is not customer with ID '2' or who have no referee at all.

SELECT 
    name
FROM 
    Customer
WHERE
    referee_id != '2'
OR
    referee_id IS NULL;
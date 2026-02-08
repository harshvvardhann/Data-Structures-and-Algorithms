-- Problem: Find patients who have a condition starting with 'DIAB1'
-- The 'conditions' column contains space-separated codes.

SELECT 
    * 
FROM 
    patients 
WHERE 
    -- Check if 'DIAB1' appears anywhere in the conditions list
    -- 1. '% DIAB1%': Matches if DIAB1 is not the first condition (preceded by a space)
    conditions LIKE '% DIAB1%' 
    OR 
    -- 2. 'DIAB1%': Matches if DIAB1 is the very first condition in the string
    conditions LIKE 'DIAB1%';
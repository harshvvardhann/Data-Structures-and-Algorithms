-- Problem: Fix the names so that only the first character is uppercase and the rest are lowercase.

SELECT 
    Users.user_id, 
    -- Concatenate the uppercase first letter with the lowercase rest of the string
    CONCAT(
        UPPER(SUBSTRING(Users.name, 1, 1)),  -- Extract first character and convert to uppercase
        LOWER(SUBSTRING(Users.name, 2))      -- Extract from 2nd character to end and convert to lowercase
    ) AS name
FROM
    Users
ORDER BY 
    Users.user_id; -- Sort results by user_id
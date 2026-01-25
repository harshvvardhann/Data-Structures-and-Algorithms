# Problem: Find the number of unique subjects taught by each teacher
# This query retrieves a count of distinct subjects for every teacher in the database

SELECT 
    teacher_id,                              -- The unique identifier for each teacher
    COUNT(DISTINCT subject_id) AS cnt        -- Count of unique subjects each teacher teaches
FROM 
    Teacher                                  -- Source table containing teacher and subject relationships
GROUP BY
    teacher_id;                              -- Group results by teacher to calculate per-teacher counts
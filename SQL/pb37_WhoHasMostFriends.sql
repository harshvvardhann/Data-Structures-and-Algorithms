-- Problem: Find the person with the most friends
-- Approach: Combine both requesters and accepters, count friend connections, return person with highest count

SELECT id, COUNT(*) AS num
FROM (
    -- Combine both directions of friend requests into a single dataset
    (
        -- Get all requesters (people who initiated accepted friend requests)
        SELECT 
            requester_id AS id
        FROM RequestAccepted 
    )
        UNION ALL
    (
        -- Get all accepters (people who accepted friend requests)
        SELECT accepter_id AS id
        FROM RequestAccepted
    )
    ) t
-- Count total friend connections for each person
GROUP BY id
-- Sort by friend count in descending order
ORDER BY num DESC
-- Return only the person with the most friends
LIMIT 1;
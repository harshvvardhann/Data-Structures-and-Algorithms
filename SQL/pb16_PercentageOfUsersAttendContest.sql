SELECT
    -- contest_id identifies each contest
    r.contest_id,

    -- Calculate the percentage of users registered in this contest
    ROUND(
        -- COUNT(r.user_id):
        -- counts how many users registered for the current contest
        COUNT(r.user_id) * 100 
        /
        -- Subquery:
        -- total number of users in the system
        (SELECT COUNT(*) FROM Users),
        -- Round the result to 2 decimal places
        2
    ) AS percentage

FROM Register r
-- Register table contains (contest_id, user_id) pairs
-- Each row represents one user registering for one contest

GROUP BY 
    -- Group rows by contest_id so aggregation
    -- (COUNT) is calculated per contest
    r.contest_id

ORDER BY
    -- Sort contests by registration percentage (highest first)
    percentage DESC,

    -- If percentages are equal, sort by contest_id (ascending)
    r.contest_id ASC;

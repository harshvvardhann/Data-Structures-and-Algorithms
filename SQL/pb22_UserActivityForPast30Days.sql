-- Problem: Track user activity for the past 30 days (June 28 to July 27, 2019)
-- This query retrieves daily active user counts for the specified date range

SELECT
    activity_date AS day,                    -- Rename activity_date column to 'day' for clarity
    COUNT(DISTINCT user_id) AS active_users -- Count unique users active on each day
FROM
    Activity                                 -- Source table containing user activity records
WHERE
    -- Filter records to include only the 30-day period from June 28 to July 27, 2019
    activity_date >= '2019-06-28'
AND 
    activity_date <= '2019-07-27'
GROUP BY
    activity_date;                           -- Group results by date to get daily counts
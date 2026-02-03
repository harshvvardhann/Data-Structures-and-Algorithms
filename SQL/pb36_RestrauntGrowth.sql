-- Problem: Calculate 7-day rolling average and sum of customer spending
-- Approach: Join daily aggregates with themselves to get 7-day window, filter for complete weeks

SELECT 
    c1.visited_on, 
    SUM(c2.amount) AS amount,                    -- Total amount spent in 7-day window
    ROUND(AVG(c2.amount),2) AS average_amount    -- Average daily spending in 7-day window
FROM 
    -- Subquery c1: Aggregate daily spending amounts
    (
        SELECT visited_on,
               SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
    ) c1    
JOIN
    -- Subquery c2: Another aggregate of daily spending (used for windowing)
    (
        SELECT visited_on,
               SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
    ) c2
ON
    -- Join condition: c2 dates must fall within 7-day window ending at c1.visited_on (current day - 6 days to current day)
    c2.visited_on BETWEEN DATE_SUB(c1.visited_on,INTERVAL 6 DAY) AND c1.visited_on
GROUP BY
    c1.visited_on
-- Filter: Only include dates that have all 7 days of data (complete weeks)
HAVING COUNT(*) = 7
ORDER BY c1.visited_on;
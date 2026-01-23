SELECT
    -- Extract year and month from the transaction date
    -- Example: 2023-07-15 → '2023-07'
    DATE_FORMAT(trans_date, '%Y-%m') AS month,

    -- Country in which the transaction occurred
    country,

    -- Total number of transactions in this (month, country) group
    COUNT(*) AS trans_count,

    -- Counts how many transactions were approved
    -- (state = 'approved') returns:
    --   1 if approved
    --   0 if not approved
    -- SUM() adds these 1s and 0s
    SUM(state = 'approved') AS approved_count,

    -- Total transaction amount (approved + declined)
    SUM(amount) AS trans_total_amount,

    -- Total amount of ONLY approved transactions
    -- CASE WHEN filters approved rows, others contribute 0
    SUM(
        CASE 
            WHEN state = 'approved' THEN amount 
            ELSE 0 
        END
    ) AS approved_total_amount

FROM Transactions
-- Each row represents one transaction
-- with date, country, state, and amount

GROUP BY
    -- Group transactions by month and country
    -- so all aggregations are calculated per (month, country)
    month,
    country;

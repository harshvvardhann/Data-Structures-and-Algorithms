SELECT 
    -- Name of the query being analyzed
    q.query_name,

    -- QUALITY:
    -- rating / position is computed per row
    -- AVG() then calculates the average quality score per query
    -- ROUND(..., 2) formats the result to 2 decimal places
    ROUND(AVG(q.rating / q.position), 2) AS quality,

    -- POOR QUERY PERCENTAGE:
    -- (rating < 3) is a boolean expression:
    --   TRUE  → 1
    --   FALSE → 0
    -- AVG(rating < 3) gives the fraction of poor queries
    -- Multiply by 100 to convert to percentage
    -- ROUND(..., 2) formats the output
    ROUND(AVG(q.rating < 3) * 100, 2) AS poor_query_percentage

FROM Queries q
-- Each row in Queries represents one execution of a query
-- with its rating and position

GROUP BY
    -- Group rows by query_name so that
    -- averages are calculated per query
    q.query_name;

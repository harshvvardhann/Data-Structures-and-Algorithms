-- Problem: List the products that have at least 100 units ordered in February 2020
-- Returns: Product name and total units ordered

SELECT
    p.product_name,
    SUM(o.unit) AS unit
FROM 
    Products p
JOIN
    Orders o
ON
    p.product_id = o.product_id
WHERE
    -- Filter orders strictly within February 2020
    o.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY
    p.product_name
HAVING 
    -- Only include products with a total order quantity of 100 or more
    SUM(o.unit)>=100
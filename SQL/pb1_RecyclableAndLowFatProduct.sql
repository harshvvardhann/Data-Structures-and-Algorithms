--  Write your MySQL query statement below
-- this query selects the product IDs of products that are both low in fats and recyclable

SELECT 
    product_id
FROM 
    Products 
WHERE 
    low_fats = 'Y' 
AND 
    recyclable = 'Y';

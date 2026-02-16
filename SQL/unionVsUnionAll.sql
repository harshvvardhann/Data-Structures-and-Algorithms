-- The UNION operator is used to combine the result-set of two or more SELECT statements, but it removes duplicate rows between the various SELECT statements.  
SELECT 
    city 
From 
    Customers 
UNION
SELECT 
    city
From 
    Suppliers;


-- The UNION ALL operator is used to combine the result-set of two or more SELECT statements, but it does not remove duplicate rows between the various SELECT statements.
SELECT 
    city 
From 
    Customers 
UNION ALL
SELECT 
    city
From 
    Suppliers;
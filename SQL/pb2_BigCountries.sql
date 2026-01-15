--  Write your MySQL query statement below
-- this query selects the names, populations, and areas of countries with an area of at least 3 million square kilometers or a population of at least 25 million.

SELECT 
    name,population,area
FROM    
    World
WHERE
    area >= '3000000'
OR
    population >= '25000000';
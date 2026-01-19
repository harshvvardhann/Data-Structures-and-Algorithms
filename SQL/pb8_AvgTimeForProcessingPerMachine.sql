# Write your MySQL query statement below

SELECT 
    machine_id,
    ROUND(
            SUM(
                CASE WHEN activity_type = 'start' THEN -timestamp ELSE timestamp END
            ) / COUNT(DISTINCT process_id)
    ,3) as processing_time

FROM 
    Activity
GROUP BY machine_id;



SELECT 
    s.machine_id, ROUND(SUM(e.timestamp - s.timestamp)/COUNT(DISTINCT s.process_id),3) as processing_time 
FROM 
    Activity s 
INNER JOIN 
    Activity e 
ON 
    s.machine_id = e.machine_id 
AND 
    s.process_id = e.process_id 
AND 
    s.activity_type = 'start' 
AND 
    e.activity_type = 'end' 
GROUP BY 
    s.machine_id
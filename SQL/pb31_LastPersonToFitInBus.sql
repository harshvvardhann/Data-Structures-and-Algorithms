
/*
  pb31_LastPersonToFitInBus.sql

  Problem summary:
  - There is a `Queue` table with (at least) columns: `turn`, `person_name`, `weight`.
  - People board the bus in ascending `turn` order.
  - The bus capacity is 1000 (units match `weight`).
  - Find the last person who can fit on the bus without exceeding capacity.

  Notes on approaches below:
  1) Aggregation + self-join approach (first query): groups by a person's turn
     and sums weights of everyone at or before that turn using a join.
     Works but can be less efficient and a bit harder to read.

  2) Window-function approach (recommended, second query): computes a running
     cumulative sum of `weight` ordered by `turn` and then picks the last
     person whose cumulative sum is <= capacity. It's concise and usually
     performs better on DBs that optimize window functions.
*/

-- Approach 1: self-join + grouping (keeps original logic for reference)
-- Find persons where sum of weights up to their turn is <= 1000, then pick
-- the one with the greatest turn (i.e., last to board and still fit).
SELECT q1.person_name 
FROM Queue q1
INNER JOIN Queue q2 ON q1.turn >= q2.turn -- join everyone up to q1's turn
GROUP BY q1.turn, q1.person_name
HAVING SUM(q2.weight) <= 1000                  -- total weight up to that turn
ORDER BY q1.turn DESC
LIMIT 1;

-- Approach 2: window function (recommended)
-- Compute running total (`total_weight`) ordered by `turn`, then select the
-- last person whose running total does not exceed 1000.
SELECT person_name
FROM (
    SELECT
        person_name,
        turn,
        SUM(weight) OVER (ORDER BY turn) AS total_weight  -- running cumulative sum
    FROM Queue
) t
WHERE total_weight <= 1000                             -- still fits on bus
ORDER BY turn DESC                                     -- latest turn first
LIMIT 1;                                               -- pick the last person who fits

-- Example assumptions:
-- Queue contents: (turn, person_name, weight)
-- (1, 'Alice', 300), (2, 'Bob', 400), (3, 'Carol', 350)
-- Running totals: 300, 700, 1050 -> Answer: 'Bob' (turn 2)

        
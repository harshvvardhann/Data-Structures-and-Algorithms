-- No ORDER BY → total per group
-- No PARTITION BY → total for entire table
-- Both → running total per group


SELECT 
    order_date,          -- The timeline → decides WHEN the money came in
    product_id,          -- The boundary → decides WHERE calculation resets
    sales_amount,        -- The current row’s value → what we add each step

    -- Window Function Begins
    SUM(sales_amount) 
        OVER (
            PARTITION BY product_id  
            -- 🔁 RESET POINT:
            -- Think: "New product → New memory → Start counting from zero"
            -- Creates logical groups without collapsing rows.
            -- Each product lives in its own universe.

            ORDER BY order_date      
            -- ⏳ TIME MACHINE:
            -- Defines the sequence of accumulation.
            -- Without this → no running logic.
            -- With this → sum grows row by row in time order.
        ) 
        AS cumulative_sales
        -- 📈 RUNNING TOTAL:
        -- Default frame:
        -- UNBOUNDED PRECEDING → CURRENT ROW
        -- Translation:
        -- "From the first sale of this product
        --  up to THIS exact row"
        --
        -- So every row answers:
        -- "How much have we earned so far for this product?"

FROM Sales;

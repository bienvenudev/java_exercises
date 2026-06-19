-- Part A
SELECT 'laptop pro' AS product_name,
999 AS price_usd,
15 AS Discount_%,
8 AS Tax_%,
42 AS stock;

-- Part B 
SELECT UPPER('laptop pro') AS product_name,
999 - (999 * 0.15) AS price_usd,
42 * 999 AS stock_value;

-- Part C
SELECT UPPER('laptop pro') AS product_name,
(999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08) AS final_price,
(999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08) > 900 AS is_above_900,
((999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08)) * 42 AS stock_value;

-- Part D
SELECT UPPER('laptop pro') AS product_name,
ROUND(((999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08)), 2) AS final_price,
(999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08) > 900 AS is_premium,
((999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08)) * 42 > 35000 AS is_stock_above_35000,
CASE 
  WHEN (999 - (999 * 0.15)) - ((999 - (999 * 0.15)) * 0.08) > 900
  THEN CONCAT(UPPER('laptop pro'), ' - ', 'PREMIUM')
  ELSE CONCAT(UPPER('laptop pro'), ' - ', 'STANDARD') 
END AS product_tag;


-- Part A
SELECT 'laptop pro' AS product_name,
999 AS price_usd,
15 AS discount_percent,
8 AS tax_percent,
42 AS stock;

-- Part B 
SELECT UPPER('laptop pro') AS product_name,
999 - (999 * 0.15) AS price_usd,
42 * 999 AS stock_value;

-- Part C
SELECT 'LAPTOP PRO' AS product_name,
849.15 + (849.15 * 0.08) AS final_price,
(849.15 + (849.15 * 0.08)) > 900 AS is_above_900,
(849.15 + (849.15 * 0.08)) * 42 AS stock_value;

-- Part D
SELECT 'LAPTOP PRO' AS product_name,
ROUND(917.082, 2) AS final_price,
917.082 > 900 AS is_premium,
38517.444 > 35000 AS is_stock_above_35000,
CASE 
  WHEN 917.082 > 900 
  THEN 'LAPTOP PRO - PREMIUM' 
  ELSE 'LAPTOP PRO - STANDARD' 
END AS product_tag;


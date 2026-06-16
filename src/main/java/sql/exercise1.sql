-- Part A
SELECT 
'john' AS first_name, 
'doe' AS last_name, 
28 AS age,
85 AS weight_kg, 
175 AS height_cm, 
38.5 AS temperature_c;

-- Part B
SELECT
UPPER(CONCAT('john', ' ', 'doe')) AS full_name,
28 AS age,
85*2.205 AS weight_lb, 
175/100 AS height_m, 
(38.5*9/5) + 32 AS temperature_f;

-- Part C
SELECT
'JOHN DOE' AS full_name,
ROUND(187.425 / ((1.75 * 39.3701) * (1.75 * 39.3701)) * 703, 2) AS bmi,
101.3 AS temperature_f,
 CASE WHEN 101.3 > 100.4 THEN 1 ELSE 0 END AS has_fever;

-- Part D
SELECT
'JOHN DOE' AS full_name,
27.7572168 AS BMI,
CASE WHEN 27.76 > 25 THEN 1 ELSE 0 END AS is_overweight,
CASE WHEN 101.3 > 100.4 THEN 1 ELSE 0 END AS has_fever,
CASE
	WHEN 27.76 > 25 OR 101.3 > 100.4
	THEN CONCAT('JOHN DOE', ' - AT RISK')
	ELSE CONCAT('JOHN DOE', ' - HEALTHY')
END AS health_tag;

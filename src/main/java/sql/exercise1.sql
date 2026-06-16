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
187.425 * 703 / ((1.75 * 39.37) * (1.75 * 39.37)) AS BMI,
'101.3' AS temperature_f,
CASE
WHEN 101.3 > 100.4 THEN 'true'
ELSE 'false'
END AS has_fever;

SET @BMI = 27.7572168;
SET @Fever = TRUE;
SET @FULLNAME = 'JOHN DOE';

-- Part D
SELECT
'JOHN DOE' AS full_name,
27.7572168 AS BMI,
CASE
WHEN 27.7572168 > 25 THEN 'TRUE'
ELSE 'FALSE'
END AS is_overweight,
'TRUE' AS has_fever,
CASE
WHEN @BMI > 25 OR @Fever = TRUE
THEN CONCAT(@FULLNAME, ' - ', 'AT RISK') 
ELSE CONCAT(@FULLNAME, ' - ', 'HEALTHY')
END AS health_tag;

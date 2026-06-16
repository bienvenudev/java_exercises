# SQL Fundamentals: Literals, Expressions & SELECT

## How These Exercises Work

Each exercise gives you a set of raw data values. Your job is to write SQL
queries that process that data step by step. Each part builds on the previous one, you must use the literal values you got from running the previous query as your inputs for the next query.

## Exercise 1: Patient Health Record

**You are given this raw patient data:**

| Field           | Value   |
| --------------- | ------- |
| First name      | `'john'`  |
| Last name       | `'doe'`   |
| Age             | `28`      |
| Weight (kg)     | `85`      |
| Height (cm)     | `175`     |
| Temperature (C) | `38.5`    |

### Part A
Write a SELECT that displays the raw patient data as it is.
### Part B
Write a SELECT that displays:
- The patient full name in uppercase
- The patient age
- The patient weight converted to pounds
- The patient height converted to meters
- The patient temperature converted to fahrenheit

**Constraints**
- You cannot write the full name as a single string literal
- You must use string expressions to build the full name
- You must use `UPPER()`
### Part C
Using the **results you got from Part B** as your literal values, write a
SELECT that displays:
- The patient full name in uppercase
- The patient BMI rounded to 2 decimal places
- The patient temperature in fahrenheit
- Whether the patient has a fever (temperature above 100.4)

**Constraints**
- BMI formula: `weight_pounds / (height_meters * height_meters) * 703`
- You cannot use `TRUE` or `FALSE` for the fever flag directly, you must compute it from the values

### Part D
Using the **results you got from Part C** as your literal values, write a SELECT that displays:
- The patient full name in uppercase
- The patient BMI
- Whether the patient is overweight (BMI above 25)
- Whether the patient has a fever
- A health tag that combines the uppercase full name with `'- AT RISK'` or `'- HEALTHY'` based on the results from Part C

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag directly
- The patient is AT RISK if they are overweight OR have a fever

## Exercise 2: Product Pricing

**You are given this raw product data:**

| Field        | Value          |
| ------------ | -------------- |
| Product name | `'laptop pro'` |
| Price (USD)  | `999`          |
| Discount (%) | `15`           |
| Tax (%)      | `8`            |
| Stock        | `42`           |
### Part A
Write a SELECT that displays the raw product data as it is.
### Part B
Write a SELECT that displays:
- The product name in uppercase
- The price after discount applied
- The total stock value (price × stock)

**Constraints**
- You cannot write the uppercased name as a single string literal
- You must use `UPPER()`
- Discount formula: `price - (price × discount / 100)`
### Part C
Using the **results from Part B** as your literal values, write a SELECT
that displays:
- The product name in uppercase
- The final price after tax is applied to the discounted price
- Whether the final price is above 900
- The total stock value after tax

**Constraints**
- Tax formula: `discounted_price + (discounted_price × tax / 100)`
- You cannot use `TRUE` or `FALSE` for any flag directly
### Part D
Using the **results from Part C** as your literal values, write a SELECT
that displays:
- The product name in uppercase
- The final price rounded to 2 decimal places
- Whether the product is premium (final price above 900)
- Whether the stock value is above 35000
- A label that combines the product name with `'- PREMIUM'` or
  `'- STANDARD'` based on the results from Part C

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use `ROUND()` for the final price

## Exercise 3: Weather Station Report

**You are given this raw weather data:**

| Field             | Value          |
| ----------------- | -------------- |
| Station name      | `'north peak'` |
| Temperature (C)   | `22.5`         |
| Humidity (%)      | `78`           |
| Wind speed (km/h) | `45`           |
| Rainfall (mm)     | `12`           |

### Part A
Write a SELECT that displays the raw station data as it is.
### Part B
Write a SELECT that displays:
- The station name in uppercase
- The temperature converted to fahrenheit
- The wind speed converted to miles per hour (km/h × 0.621)
- The rainfall converted to inches (mm × 0.0393)

**Constraints**
- You cannot write the uppercased name as a single string literal
- You must use `UPPER()`
- Fahrenheit formula: `(C × 9/5) + 32`

### Part C
Using the **results from Part B** as your literal values, write a SELECT
that displays:
- The station name in uppercase
- Whether the temperature is considered hot (above 86F)
- Whether the wind is considered strong (above 25 mph)
- Whether the rainfall is considered heavy (above 0.4 inches)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
### Part D
Using the **results from Part C** as your literal values, write a SELECT
that displays:
- The station name in uppercase
- Whether conditions are dangerous (strong wind AND heavy rainfall)
- Whether an advisory should be issued (dangerous OR hot)
- A status label that combines the station name with `'- ADVISORY'` or
  `'- CLEAR'` based on the results from Part C

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag directly

## Exercise 4: Weather Station Report with Missing Data

**You are given this raw weather data:**

| Field             | Value          |
| ----------------- | -------------- |
| Station name      | `'north peak'` |
| Temperature (C)   | `22.5`         |
| Humidity (%)      | `78`           |
| Wind speed (km/h) | `45`           |
| Rainfall (mm)     | `12`           |
| UV Index          | `NULL`         |

### Part A
Write a SELECT that displays the raw station data as it is including the
missing UV index.

### Part B
Write a SELECT that displays:
- The station name in uppercase
- The temperature converted to fahrenheit
- The wind speed converted to miles per hour (km/h × 0.621)
- The rainfall converted to inches (mm × 0.0393)
- Whether the UV index is missing
- The result of adding 5 to the UV index

**Constraints**
- You cannot write the uppercased name as a single string literal
- You must use `UPPER()`
- You must use `IS NULL` to check for the missing UV index
- You cannot use `TRUE` or `FALSE`

> Notice what happens when you try to do arithmetic with a missing value

### Part C
Using the **results from Part B** as your literal values, write a SELECT
that displays:
- The station name in uppercase
- The temperature in fahrenheit
- The wind speed in mph
- Whether the temperature is considered hot (above 86F)
- Whether the wind is considered strong (above 25 mph)
- Whether the rainfall is considered heavy (above 0.4 inches)
- Whether the UV index is missing
- The result of comparing UV index to 5 using `=`

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use both `=` and `IS NULL` when dealing with the UV index

> Notice the difference between checking NULL with `=` versus `IS NULL`
### Part D
Using the **results from Part C** as your literal values, write a SELECT
that displays:
- The station name in uppercase
- Whether conditions are dangerous (strong wind AND heavy rainfall)
- Whether an advisory should be issued (dangerous OR hot)
- Whether a full report is possible (UV index IS NOT NULL)
- The result of (dangerous AND whether UV index is missing)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use `IS NOT NULL` for the full report check

> Notice how NULL affects the result of AND and OR expressions
### Part E
Using the **results from Part D** as your literal values, write a SELECT
that displays:
- The station name in uppercase
- Whether an advisory should be issued
- Whether a full report is possible
- A status label that produces:
    - `'- ADVISORY'` if an advisory should be issued
    - `'- INCOMPLETE'` if a full report is not possible
    - `'- CLEAR'` otherwise

**Constraints**
- You cannot use `TRUE` or `FALSE`

## Exercise 5: Stock Market Report

**You are given this raw stock data:**

| Field                 | Value          |
| --------------------- | -------------- |
| Company name          | `'tech corp'`  |
| Opening price (USD)   | `142.50`       |
| Closing price (USD)   | `156.80`       |
| Volume (millions)     | `3.2`          |
| Market cap (billions) | `NULL`         |
| Sector                | `'technology'` |

### Part A
Write a SELECT that displays the raw stock data as it is.
### Part B
Write a SELECT that displays:
- The company name formatted as `'TICKER: TECH CORP'`
- The price change (closing minus opening)
- The price change as a percentage of the opening price rounded to 2
  decimal places
- The volume converted to actual number of shares (millions × 1,000,000)
- Whether the market cap data is missing
- The result of adding 100 to the market cap

**Constraints**
- You cannot write `'TICKER: TECH CORP'` as a single string literal, you
  must build it using string expressions
- You must use `UPPER()` and `CONCAT()`
- You must use `IS NULL` to check for missing market cap
- You cannot use `TRUE` or `FALSE`

> Notice what happens when you try to do arithmetic with a missing value
### Part C
Using the **results from Part B** as your literal values, write a SELECT
that displays:
- The formatted company name
- Whether the stock had a positive day (price change above 0)
- Whether the stock is high volume (shares above 3,000,000)
- Whether the percentage change is significant (above 5%)
- The result of comparing market cap to NULL using `=`
- Whether a full analysis is possible (market cap IS NOT NULL)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use both `=` and `IS NOT NULL` when dealing with market cap

> Notice the difference between checking NULL with `=` versus `IS NOT NULL`
### Part D
Using the **results from Part C** as your literal values, write a SELECT
that displays:
- The formatted company name
- Whether the stock is a strong performer (positive day AND significant
  change AND high volume)
- Whether the stock deserves attention (strong performer OR significant
  change)
- The result of (strong performer AND market cap IS NULL)
- Whether a complete report can be generated (full analysis IS NOT NULL)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use `IS NULL` and `IS NOT NULL` where appropriate

> Notice how NULL affects the result of AND expressions
### Part E
Using the **results from Part D** as your literal values, write a SELECT
that displays:
- The formatted company name
- Whether the stock deserves attention
- Whether a complete report can be generated
- A rating label that produces:
    - `'- STRONG BUY'` if strong performer and complete report is possible
    - `'- BUY'` if deserves attention but report is incomplete
    - `'- HOLD'` if does not deserve attention but report is possible
    - `'- INSUFFICIENT DATA'` otherwise

**Constraints**
- You cannot use `TRUE` or `FALSE`
## Exercise 6: Flight Operations Report

**You are given this raw flight data:**

| Field                | Value   |
| -------------------- | ------- |
| Flight code          | `'aa'`  |
| Flight number        | `'447'` |
| Departure time (24h) | `1430`  |
| Arrival time (24h)   | `1645`  |
| Passengers           | `180`   |
| Capacity             | `220`   |
| Fuel used (liters)   | `8450`  |
| Delay (minutes)      | `NULL`  |
| Distance (km)        | `1240`  |

### Part A
Write a SELECT that displays the raw flight data as it is.
### Part B
Write a SELECT that displays:
- The full flight code formatted as `'FLIGHT: AA-447'` built entirely from
  the raw values
- The flight duration in minutes derived from departure and arrival time
- The flight duration in hours rounded to 2 decimal places
- The passenger load factor as a percentage (passengers / capacity × 100)
  rounded to 1 decimal place
- The fuel efficiency in liters per kilometer rounded to 2 decimal places
- Whether the delay data is missing
- The result of adding 30 to the delay

**Constraints**
- You cannot write `'FLIGHT: AA-447'` as a single string literal, you must
  build it using string expressions
- You must use `UPPER()` and `CONCAT()`
- Duration in minutes formula: `arrival_time - departure_time`
- You must use `IS NULL` to check for missing delay
- You cannot use `TRUE` or `FALSE`

> Notice what happens when you try to do arithmetic with a missing value

---

### Part C
Using the **results from Part B** as your literal values, write a SELECT
that displays:
- The formatted flight code
- The flight duration in hours
- The fuel efficiency in liters per km
- Whether the flight is long haul (duration above 3 hours)
- Whether the flight is full (load factor above 85%)
- Whether the fuel consumption is high (above 7 liters per km)
- The result of comparing delay to 0 using `=`
- Whether delay data is available (delay IS NOT NULL)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use both `=` and `IS NOT NULL` when dealing with delay

> Notice the difference between checking NULL with `=` versus `IS NOT NULL`

---

### Part D
Using the **results from Part C** as your literal values, write a SELECT
that displays:
- The formatted flight code
- Whether the flight is efficient (long haul AND load factor above 85%
  AND fuel consumption NOT high)
- Whether the flight needs a review (high fuel consumption OR delay
  IS NOT NULL)
- The result of (needs review AND delay IS NULL)
- Whether a complete operations report is possible (delay IS NOT NULL)

**Constraints**
- You cannot use `TRUE` or `FALSE` for any flag
- You must use `IS NULL` and `IS NOT NULL` where appropriate

> Notice how NULL affects the result of AND and OR expressions

---

### Part E
Using the **results from Part D** as your literal values, write a SELECT
that displays:
- The formatted flight code
- Whether the flight is efficient
- Whether the flight needs a review
- Whether a complete report is possible
- An operations label that produces:
    - `'- OPTIMAL'` if efficient and complete report is possible
    - `'- REVIEW REQUIRED'` if needs review and complete report is possible
    - `'- EFFICIENT BUT INCOMPLETE'` if efficient but report is incomplete
    - `'- GROUNDED'` if not efficient and needs review
    - `'- INSUFFICIENT DATA'` otherwise

**Constraints**
- You cannot use `TRUE` or `FALSE`

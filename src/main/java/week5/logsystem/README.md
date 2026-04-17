# Exercise 1. Log Processing System
**hint:** (Regex + Set + Map + File I/O)
## Scenario

You are building a command-line log analysis tool for a system administrator.

The program receives **the log file name as input** (e.g., `system.log`).

Each valid log entry follows this structure:
```java
<timestamp> <level> <message>
```

Example:
```java
2026-01-01 10:00:00 ERROR User123 failed login
```

### Structure details:

- **timestamp** → `yyyy-MM-dd HH:mm:ss`
- **level** → one of: `INFO`, `WARNING`, `ERROR`
- **message** → free text
    - Contains username in the format:  User[alphanumeric] like `User123`
## Important Constraints

The log file is **not clean**:
- Some lines are malformed
- Some lines have missing parts
- Some lines have invalid log levels
- Some lines are duplicated

Your system must **handle all of this gracefully**.

# Phase 1: Raw Cleaning (Before Parsing)

Work at the **string level (no objects yet)**
### Tasks:

1. Read the file line by line (file name comes from user input)
2. Ignore invalid lines:
    - Lines that don’t match the expected structure at all
    - Lines with missing timestamp, level, or message
3. Normalize:
    - Trim whitespace
    - Normalize spacing (e.g., multiple spaces → single space)
4. Normalize log level:
    - Convert to uppercase
5. Remove exact duplicate lines (**hint:** Sets could be helpful)

# Phase 2: Parsing (Structured Data)

Now convert cleaned lines into objects.

### Tasks:

6. Use **regex** to extract:
    - timestamp
    - level
    - message
7. Create LogEntry class:
    ```java
    class LogEntry {  
 
    }
    ```


8. Skip lines that:
    - still fail regex extraction
    - contain invalid timestamp format (handle parsing errors)

This is where parsing and cleaning overlap:
- structural validation happens here
- anything that “looked valid” before but fails now is discarded
# Phase 3: Data Refinement

Now work on structured data.

### Tasks:
9. Extract username from message using regex  
   Example:

   User123 failed login → User123

10. Optionally extend `LogEntry`:

String username; // nullable

11. Remove logical duplicates:

- same timestamp + level + message
# Phase 4: Analysis

### Tasks:

12. Count logs per level: Map<String, Integer>
13. Count errors per user: Map<String, Integer>
14. Identify:
    - most frequent error message
    - user with most errors

---

# Phase 5: Output

### Tasks:

15. Write cleaned logs to: cleaned_[inputFileName]
16. Sort logs by timestamp before writing
17. Write summary to `summary.txt`:

Example:
```
ERROR: 5  
INFO: 3  
WARNING: 2  
  
Top Error User: User123 (3 errors)  
  
Most Frequent Error:  
"failed login" (4 times)
```


---

# Phase 6: Extensions

Pick a few:
### Filtering

18. Allow user to filter by log level (e.g., only ERROR)

### Time range

19. Show logs between two timestamps

### Iterator usage

20. Re-implement one part using explicit `Iterator`

### Data structure choice

21. Replace `HashSet` with `LinkedHashSet`  
    → observe ordering difference

# Log Processing & Analytics System (Concurrent Worker Pipeline)
Build a command-line system that processes logs from multiple sources.

The system must:
- process logs in the background
- use a fixed number of workers
- handle many logs efficiently
- produce correct analytics
- remain responsive while processing

Each log takes about **1 minute (simulated delay)** to process.

##  Log Structure

Each log has:
- `id`
- `source` (API, UI, SYSTEM, etc.)
- `message`
- `severity` (INFO, WARN, ERROR)
## CLI Commands
```
generate  
process  
report  
exit
```

## Requirements
### 1. Generate Logs
- `generate` creates a batch of logs.
- Logs must come from different sources.
- All generated logs are stored in a shared list.
### 2. Process Logs
- `process` starts processing all pending logs.

Each log must:
- take ~1 minute (simulated delay)
- be marked as:
    - PROCESSING while running
    - DONE when finished
    - FAILED if an error occurs
### 3. Background Execution (Required)
- Processing must NOT block the CLI.
- While logs are processing, the user must still be able to:
    - generate new logs
    - request reports
    - start processing again
### 4. Concurrent Processing
- Multiple logs must be processed at the same time.
- Logs must be processed independently.

### 5. Fixed Number of Workers (IMPORTANT RULE)
The system must use a **fixed number of workers**.
#### Rules:
- You must define a constant number of workers (e.g. 3 or 5).
- This number does NOT change during runtime.
- You are NOT allowed to:
    - create a new worker per log
    - exceed the worker limit
#### Behavior:
- Only a limited number of logs can be processed at the same time.
- Remaining logs must wait.
### 6. Queue System
- If more logs exist than available workers:
    - they must wait in a queue
- Workers must automatically pick the next available log when free.
### 7. Worker Identity Tracking
Each worker must track:
- its own name or ID
- how many logs it has processed

This information must be:
- unique per worker
- not shared between workers

Each log processing must print:
- worker ID
- log ID
- log source

## 8. Shared Analytics Storage
The system must track global statistics:
- total logs processed
- logs per source
- logs per severity

This data is shared across all workers.
### 9. Concurrency Issues (Expected)
During processing, you may observe:
- incorrect counts
- missing updates
- inconsistent reports

This is expected in early implementation.

### 10. Fix Requirements
You must modify the system so that:
- all analytics are always correct
- multiple workers can update shared data safely
- concurrency is still preserved

You are NOT allowed to:
- remove parallel processing
- reduce number of workers to 1
## 11. Reporting System
- `report` prints:
    - total logs processed
    - logs per source
    - logs per severity
    - worker activity summary

## 12. Final System Behavior
Your system must:
- generate logs from multiple sources
- process logs concurrently
- use a fixed number of workers
- queue excess logs automatically
- track per-worker processing
- maintain correct global statistics
- remain responsive at all times
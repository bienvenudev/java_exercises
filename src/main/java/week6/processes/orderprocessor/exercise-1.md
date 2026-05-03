# Exercise 1. Multi-Threaded Order Processing System (CLI)

Build a command-line application that manages and processes customer orders.  The system must allow adding orders, processing them, and checking their status while processing happens in the background.

Each order takes **~2 minute to process**.
## Order Structure
Each order must contain:
- an ID
- an amount
- a status:
    - PENDING
    - PROCESSING
    - DONE
    - FAILED

## CLI Commands
Your program must continuously accept user input:
```
add  
process  
status  
stop  
exit
```
## Requirements

### 1. Order Management
- You must be able to add new orders.
- Each order must start with status: `PENDING`.
- You must store multiple orders.
### 2. View Orders
- The `status` command must display all orders.
- Show:
    - ID
    - amount
    - current status
### 3. Processing Orders
- The `process` command starts processing ONE pending order.
- Processing must:
    - take ~2 minute
    - change status from `PENDING → PROCESSING → DONE`
- The system must remain usable while processing happens.
### 4. Background Execution
- Processing must NOT block the CLI.
- You must be able to:
    - add orders
    - check status
    - start more processing  
        while other orders are still processing.

### 5. Multiple Orders Processing
- You must support processing multiple orders at the same time.
- Each order must be handled independently.

### 6. Order Completion Tracking
- Keep track of how many orders have been completed.
- Display this number in the `status` command.

### 7. Stop Command
- The `stop` command must stop all running order processing.
- Running orders must stop as soon as possible.
- Stopped orders should NOT be marked as DONE.

### 8. Failure Handling
- Some orders must randomly fail during processing(throw an exception).
- Failed orders must be marked as `FAILED`.
- A failure in one order must NOT affect others.

## Final Expected Behavior
Your system should:
- process multiple orders at the same time
- remain responsive at all times
- correctly show order states
- correctly track completed orders
- stop processing when requested
- handle failures safely

# Java Exercises

A collection of Java exercises completed week by week, covering core Java concepts such as OOP, collections, control flow, and more.

## Structure

```
src/main/java/
├── org/example/              # Introductory examples and helpers
├── week4/
│   └── attendance/           # Week 4 – Attendance Tracker
├── week5/
│   └── logsystem/            # Week 5 – Log System
├── week6/
│   └── processes/            # Week 6 – Concurrency & Processes
│       ├── videoprocessor/
│       ├── orderprocessor/
│       └── loganalytics/
└── week7/                    # Week 7 – Stream API & Functional Programming
    ├── exercise1/
    ├── exercise2/
    ├── exercise3/
    ├── exercise4/
    └── exercise5/
```

## Exercises

### Week 4 – Attendance Tracker (`week4/attendance`)

A terminal program that helps a teacher manage student attendance.

**Features:**
- Add students to a class (with duplicate prevention)
- Mark a student as present
- Display attendance summary as a percentage
- Display all students with their attendance status
- Mark all students as absent

**How to run:**
Run the `main` method in `Attendance.java`.

**Classes:**
| Class | Responsibility |
|---|---|
| `Student` | Represents a student with a name and attendance status |
| `Registrar` | Manages the class list and all attendance operations |
| `Attendance` | Entry point — handles user input/output via the terminal |

### Week 5 – Log System (`week5/logsystem`)

A log file parser that extracts, validates, and analyzes system logs using regex patterns.

**Features:**
- Parse structured log entries with timestamp, level, and message
- Extract log entries using regex validation
- Group logs by level (INFO, WARNING, ERROR)
- Track errors per user
- Generate cleaned log file and summary report

**How to run:**
Run the `main` method in `Log.java`.

**Key Concepts:**
- Regex pattern matching
- File I/O with BufferedReader and FileWriter
- Collections (Set, Map, List)
- String parsing and manipulation

### Week 6 – Processes (`week6/processes`)

Concurrency exercises demonstrating multi-threaded systems with realistic task simulation.

**Subexercises:**

| Exercise | Description |
|---|---|
| `VideoProcessor` | Process multiple video encoding tasks concurrently with thread-safe state |
| `OrderProcessor` | Handle order processing with background workers managing a shared task queue |
| `LogAnalytics` | Analyze log data using multiple threads to process segments in parallel |

**Key Concepts:**
- Creating and starting threads
- Thread coordination and synchronization
- Shared data safety
- Task queues and worker patterns
- Thread sleep for simulating delays

### Week 7 – Stream API & Functional Programming (`week7`)

A series of exercises using Java Streams and functional programming patterns for data transformation and aggregation.

**Exercises:**

| Exercise | Focus | Classes |
|---|---|---|
| 1 | Stream filtering and collection operations | `Student`, `StudentFilter` |
| 2 | Mapping and formatting streams | `Product`, `ProductProcessing` |
| 3 | Stream aggregation on complex data | `Movie`, `MovieProcessing` |
| 4 | Optional handling and stream operations | `Student`, `CourseAnalysis` |
| 5 | Advanced aggregation and grouping | `Order`, `SalesReport` |

**Key Concepts:**
- Stream API (filter, map, sorted, collect)
- Records (data carriers)
- Optional for null-safe operations
- Comparators and sorting
- String formatting with streams

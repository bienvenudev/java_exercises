# Java Exercises

A collection of Java exercises completed week by week, covering core Java concepts such as OOP, collections, control flow, and more.

## Structure

```
src/main/java/
├── org/example/        # Introductory examples and helpers
└── week4/
    └── attendance/     # Week 4 – Attendance Tracker
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

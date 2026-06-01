package week7.exercise4;

import java.util.List;
import java.util.Optional;

public class CourseAnalysis {
    static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", "Java", 100),
                new Student("Bob", "Java", 75),
                new Student("Charlie", "Python", -40),
                new Student("David", "Java", 90),
                new Student("Emma", "Python", 100),
                new Student("Frank", "JavaScript", 20)
        );

        long studentsInJava = students
                .stream()
                .filter(student -> student.course().equals("Java"))
                .count();
        long completedCourseCount = students
                .stream()
                .filter(student -> student.completionPercentage() == 100)
                .count();

        boolean hasZeroProgressStudent = students
                .stream()
                .anyMatch(student -> student.completionPercentage() == 0);

        boolean isAllGreaterThanTen = students
                .stream()
                .allMatch(student -> student.completionPercentage() > 10);
        boolean noStudentBelowZero = students
                .stream()
                .noneMatch(student -> student.completionPercentage() < 0);

        Optional<Student> firstCompleted = students
                .stream()
                .filter(student -> student.completionPercentage() == 100)
                .findFirst();
        Optional<Student> pythonStudent = students
                .stream()
                .filter(student -> student.course().equals("Python"))
                .findAny();

        System.out.println("Students enrolled in the \"Java\" course: " + studentsInJava);
        System.out.println("Students who have completed the course (progress == 100): " + completedCourseCount);
        System.out.println("At least one student has 0% progress: " + hasZeroProgressStudent);
        System.out.println("All students have progress greater than 10: " + isAllGreaterThanTen);
        System.out.println("No student has progress below 0: " + noStudentBelowZero);
        firstCompleted.ifPresent(student -> System.out.println("The first student who completed a course: " + student.name()));
        pythonStudent.ifPresent(student -> System.out.println("Any student enrolled in \"Python\": " + student.name()));
    }
}

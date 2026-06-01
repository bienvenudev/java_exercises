package week7.exercise4;

import java.util.List;

public class CourseAnalysis {
    static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", "Java", 100),
                new Student("Bob", "Java", 75),
                new Student("Charlie", "Python", 40),
                new Student("David", "Java", 90),
                new Student("Emma", "Python", 100),
                new Student("Frank", "JavaScript", 20)
        );

        boolean zeroProgressCount = !students.stream().filter(student -> student.completionPercentage() == 0).toList().isEmpty();
        boolean isAllGreaterThanTen = students.stream().allMatch(student -> student.completionPercentage() > 10);
        boolean isAnyBelowZero = students.stream().anyMatch(student -> student.completionPercentage() < 0);

        List<Student> firstToComplete = students.stream().takeWhile(student -> student.completionPercentage() == 100).toList();
        List<Student> pythonStudent = students.stream().filter(student -> student.course().equals("Python")).toList();

        System.out.println("Students enrolled in the \"Java\" course and have completed the course (progress == 100): " + completedJava(students));
        System.out.println("At least one student has 0% progress: " + zeroProgressCount);
        System.out.println("All students have progress greater than 10: " + isAllGreaterThanTen);
        System.out.println("No student has progress below 0: " + !isAnyBelowZero);
        System.out.println("The first student who completed a course: " + firstToComplete.getFirst().name());
        System.out.println("Any student enrolled in \"Python\": " + pythonStudent.getFirst().name());
    }

    static int completedJava(List<Student> students) {
        return students
                .stream()
                .filter(student -> student.course().equals("Java"))
                .filter(student -> student.completionPercentage() == 100)
                .toList()
                .size();
    }
}

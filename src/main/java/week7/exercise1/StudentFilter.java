package week7.exercise1;

import java.util.Comparator;
import java.util.List;

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", 22, 85.5),
                new Student("Bob", 19, 72.0),
                new Student("Charlie", 25, 10.2),
                new Student("David", 20, 68.4),
                new Student("Emma", 23, 88.8),
                new Student("Frank", 18, 95.1),
                new Student("Nadia", 28, 45.1),
                new Student("Cecile", 20, 99.4),
                new Student("Jack", 32, 50.1)
        );

        List<String> topStudentNames = students
                .stream()
                .filter((student) -> student.age() > 20 && student.average() > 80)
                .sorted(Comparator.comparingDouble(Student::average).reversed())
                .map(student -> student.name().toUpperCase())
                .toList();

        System.out.println("Top Student Names: " + topStudentNames);
        System.out.println("All Students: " + students);
    }
}

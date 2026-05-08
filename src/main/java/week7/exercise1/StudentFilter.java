package week7.exercise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentFilter {
    public void main () {
        List<Student> topStudents = students.
                stream()
                .filter((student) -> student.age() > 20 && student.average() > 80)
                .sorted(Comparator.comparingDouble(Student::average).reversed())
                .toList();

        System.out.println("Top Students: " + topStudents);

        List<String> studentNames = topStudents
                .stream()
                .map(student -> student.name().toUpperCase())
                .toList();

        System.out.println("Student Names: " + studentNames);
        System.out.println("Original Students: " + students);
    }

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
}

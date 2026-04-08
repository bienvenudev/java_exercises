package week4.attendance;

import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

// admit students, mark them as present, count present students, display all students w/ attendance status;

public class Registrar {
    private final List<Student> myClass = new ArrayList<>();
    private final Set<String> uniqueNames = new HashSet<>();

    Scanner scanner = new Scanner(System.in);


    public void addStudent(Student newStudent) {
        if (uniqueNames.add(newStudent.getName())) {
            myClass.add(newStudent);
            System.out.println(newStudent.getName() + " is added!");
        } else {
            System.out.println("Student already exists!");

        }
    }

    public void markStudentPresent() {
        if (myClass.isEmpty()) {
            System.out.println("No students available in your class!");
            return;
        }

        System.out.println("Enter name of present student");
        String presentStudentName = scanner.nextLine();

        boolean studentFound = false;

        for (Student student : myClass) {
                if (student.getName().equals(presentStudentName)) {
                    student.setPresent(true);
                    studentFound = true;
                    System.out.println(student.getName() + " marked as present!");
                }
            }

            if (!studentFound) {
                System.out.println("Wrong name, Students are:  " + myClass.stream().map(Student::getName).toList());
            }
    }

    public void displayAttendanceSummary() {
        if (myClass.isEmpty()) {
            System.out.println("No students available in your class!");
            return;
        }

        int count = 0;

        for (Student student : myClass) {
            if (student.isPresent()) {
                count++;
            }
        }
        System.out.printf("Present students are %.0f%%", ((float) count / myClass.size()) * 100);
    }

    public void displayAllStudents() {
        if (myClass.isEmpty()) {
            System.out.println("No students available in your class!");
            return;
        }

        for (Student student : myClass) {
            System.out.print(student.getName() + ": " + (student.isPresent() ? "Present, " : "Absent, "));
        }
    }

    public void markAllAbsent() {
        if (myClass.isEmpty()) {
            System.out.println("No students available to mark as absent!");
            return;
        }

        for (Student student : myClass) {
            student.setPresent(false);
        }
    }
}

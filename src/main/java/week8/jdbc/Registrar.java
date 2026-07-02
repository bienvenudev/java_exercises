package week8.jdbc;

import org.sqlite.SQLiteDataSource;
import week8.jdbc.Student;
import week8.jdbc.Attendance.*;


import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import static week8.jdbc.Attendance.jdbc;

// admit students, mark them as present, count present students, display all students w/ attendance status;

public class Registrar {
    private final List<Student> myClass = new ArrayList<>();
    private final Set<String> uniqueNames = new HashSet<>();

    Scanner scanner = new Scanner(System.in);

    public void addStudent(Student newStudent) {
        // replace with try-catch w/ resources where we add a student but since we'll make name unique and primary key,
        // then it should fail to create a duplicate then in catch depending on the type of exception we print "already exists"
        try {
        Connection con = jdbc();

        String insert = "INSERT INTO students VALUES (?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(insert)) {
            preparedStatement.setString(1, newStudent.getName());
            preparedStatement.setInt(2, 0); // new student always starts with absent status

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            if (e.getSQLState() == null) {
                System.err.println("Student already exists!");
            }
        }

        } catch (SQLException e) {
            e.printStackTrace();
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
//        if (myClass.isEmpty()) {
//            System.out.println("No students available in your class!");
//            return;
//        }
//
//        for (Student student : myClass) {
//            System.out.print(student.getName() + ": " + (student.isPresent() ? "Present, " : "Absent, "));
//        }

        String sql = "SELECT * FROM students";

        try (Connection con = jdbc();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.wasNull()) {
//                    System.out.println("No students available in your class!");
//                    return;
//                }

                while (rs.next()) {
                    String name = rs.getString("name");
                    int is_present_int = rs.getInt("is_present");

                    System.out.println(name + ": " + (is_present_int == 1 ? "Present" : "Absent"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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


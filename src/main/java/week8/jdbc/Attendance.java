package week8.jdbc;

import week8.jdbc.Registrar;
import week8.jdbc.Student;

import org.sqlite.SQLiteDataSource;

import java.sql.*;

import java.util.Scanner;

public class Attendance {
    public static Connection jdbc() throws SQLException {
        String url = "jdbc:sqlite:students.db";

        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(url);
        Connection con = ds.getConnection();

        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = jdbc();

        try (con){
            if (con.isValid(5)) {
                System.out.println("Connection is valid.");
            }

            try (Statement statement = con.createStatement()){
                try (ResultSet rs = statement.executeQuery("SELECT * FROM students")){
                    while(rs.next()) {
                        System.out.println(rs.getString("name") + " " + rs.getInt("is_present"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        Registrar registrar = new Registrar();

        while (isRunning) {
            System.out.println(
                    "\nInput\n1: Add student\n2: Mark student as present\n3: See how many students present\n4: Display all students\n5: Mark all students absent\n6: Terminate program");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    System.out.println("Enter name of new student");
                    String newStudentName = scanner.nextLine();
//                    replace this addstudent to a jdbc statement that adds these columns in the table
                    registrar.addStudent(new Student(newStudentName, false));
                    break;
                case 2:
                    registrar.markStudentPresent();
                    break;
                case 3:
                    registrar.displayAttendanceSummary();
                    break;
                case 4:
                    registrar.displayAllStudents();
                    break;
                case 5:
                    registrar.markAllAbsent();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!\n Retry\n");
                    break;
            }
        }

    }
}


package week4.attendance;

import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        Registrar registrar = new Registrar();

        while (isRunning) {
            System.out.println(
                    "\nInput\n1: Add student\n2: Mark student as present\n3: See how many students present\n4: Display all students\n5: Mark all students absent\n6: Terminate program");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name of new student");
                    // Scanner scanner1 = new Scanner(System.in);
                    String newStudentName = scanner.nextLine();

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

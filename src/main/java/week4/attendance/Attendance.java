package week4.attendance;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Attendance {
     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean switcher = true;
        Registrar registrar = new Registrar();
        Set<String> uniqueNames = new HashSet<>();

        while(switcher) {
            System.out.println("\nInput\n1: Add student\n2: Mark student as present\n3: See how many students present\n4: Display all students\n5: Mark all students absent\n6: Terminate program");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name of new student");
//                    Scanner scanner1 = new Scanner(System.in);
                    String newStudentName = scanner.nextLine();

                    if(uniqueNames.add(newStudentName)){
                        registrar.addStudent(new Student(newStudentName, false));
                    } else {
                        System.out.println("Student already exists!");
                    }
                    break;
                case 2:
                    if(registrar.getMyClass().isEmpty()) {
                        System.out.println("No students in your class!");
                        break;
                    }
                    System.out.println("Enter name of present student");
                    String presentStudentName = scanner.nextLine();

                    registrar.markStudentPresent(presentStudentName);
                    break;
                case 3:
                    registrar.presentAttendance();
                    break;
                case 4:
                    registrar.displayAllStudents();
                    break;
                case 5:
                    registrar.markAllAbsent();
                    break;
                case 6:
                    switcher = false;
                    break;
                default:
                    System.out.println("Wrong input!\n Retry\n");
                    break;
            }
        }

    }
 }

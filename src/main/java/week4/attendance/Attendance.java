package week4.attendance;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Attendance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean switcher = true;

        System.out.println("Input\n1: Add student\n2: Mark student as present\n3: See how many students present\n4: Display all students\n5: Terminate Program");
        int choice = scanner.nextInt();

        List<Student> myClass = new ArrayList<>();

        while(switcher) {
            switch (choice) {
                case 1:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Input the student's name:");
                    String studentName = scanner2.nextLine();

                    Student student = new Student(studentName, false);

                    myClass.add(student);
                    System.out.println(student.name);
                    System.out.println(student.status);
                    break;
                case 5:
                    switcher = false;
                    break;
                default:
                    System.out.println("Wrong input!\n");
                    break;
            }
        }

    }
 }

 class Student {
    String name;
    boolean status;

    public Student (String name, boolean status) {
        this.name = name;
        this.status = status;
    }
 }

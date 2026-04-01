package week4.attendance;

import java.util.ArrayList;
import java.util.List;

// admit students, mark them as present, count present students, display all students w/ attendance status;

public class Registrar {
    private final List<Student> myClass = new ArrayList<>();

    public List<Student> getMyClass() {
        return myClass;
    }

    public void addStudent(Student newStudent) {
        myClass.add(newStudent);
        System.out.println(newStudent.name + " is added!");
    }

    public void markStudentPresent(String presentStudentName) {
        boolean studentFound = false;

        for (Student student: myClass) {
            if (student.name.equals(presentStudentName)) {
                student.isPresent = true;
                studentFound = true;
                System.out.println(student.name + " marked as present!");
            }
        }

        if(!studentFound) {
            System.out.println("Wrong name, Please enter the correct name."); // would love to map through students and do System.out.println("Wrong name, Please enter the correct name.\n Your students are: " + myClass.stream().map(Student student)
        }
    }

    public void presentAttendance() {
        if(myClass.isEmpty()) {
            System.out.println("No students available in your class!");
            return;
        }

        int count = 0;

        for(Student student: myClass) {
            if (student.isPresent) {
                count++;
            }
        }
        System.out.printf("Present students are %.0f%%", ((float) count / myClass.size()) * 100);
    }

    public void displayAllStudents() {
        if(myClass.isEmpty()) {
            System.out.println("No students in your class!");
        }

        for (Student student: myClass) {
            System.out.print(student.name + ": " + (student.isPresent ? "Present, " : "Absent, "));
        }
    }

    public void markAllAbsent() {
        if (myClass.isEmpty()) {
            System.out.println("No students available to mark as absent!");
            return;
        }

        for(Student student: myClass) {
            student.isPresent = false;
        }
    }
}

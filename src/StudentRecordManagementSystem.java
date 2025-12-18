import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Student class stores all student info
class Student {
    int id;
    String name;
    int age;
    String course;
    String phone;

    Student(int id, String name, int age, String course, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.phone = phone;
    }
}

public class StudentRecordManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Delete Student");
            System.out.println("6. Modify Student");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudentByID(); break;
                case 4: searchStudentByName(); break;
                case 5: deleteStudent(); break;
                case 6: modifyStudent(); break;
                case 7: System.out.println("Exiting system. Thank you!"); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add a new student
    static void addStudent() {
        System.out.print("Enter ID: "); int id = getIntInput(); sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Age: "); int age = getIntInput(); sc.nextLine();
        System.out.print("Enter Course: "); String course = sc.nextLine();
        System.out.print("Enter Phone: "); String phone = sc.nextLine();

        studentList.add(new Student(id, name, age, course, phone));
        System.out.println("Student added successfully.");
    }

    // View all students, sorted by ID
    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        // Sort by ID
        Collections.sort(studentList, Comparator.comparingInt(s -> s.id));

        System.out.println("Total Students: " + studentList.size());
        for (Student s : studentList) {
            System.out.println("---------------------------");
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);
            System.out.println("Course: " + s.course);
            System.out.println("Phone: " + s.phone);
        }
    }

    // Search by ID
    static void searchStudentByID() {
        System.out.print("Enter Student ID to search: "); int id = getIntInput();
        for (Student s : studentList) {
            if (s.id == id) {
                System.out.println("Student Found:");
                displayStudent(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search by Name
    static void searchStudentByName() {
        System.out.print("Enter Student Name to search: "); sc.nextLine();
        String name = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Student s : studentList) {
            if (s.name.toLowerCase().contains(name)) {
                displayStudent(s);
                found = true;
            }
        }
        if (!found) System.out.println("No students found with that name.");
    }

    // Delete student
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: "); int id = getIntInput();
        for (Student s : studentList) {
            if (s.id == id) {
                studentList.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Modify student
    static void modifyStudent() {
        System.out.print("Enter Student ID to modify: "); int id = getIntInput(); sc.nextLine();
        for (Student s : studentList) {
            if (s.id == id) {
                System.out.print("Enter new Name: "); s.name = sc.nextLine();
                System.out.print("Enter new Age: "); s.age = getIntInput(); sc.nextLine();
                System.out.print("Enter new Course: "); s.course = sc.nextLine();
                System.out.print("Enter new Phone: "); s.phone = sc.nextLine();
                System.out.println("Student modified successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Helper to display student
    static void displayStudent(Student s) {
        System.out.println("---------------------------");
        System.out.println("ID: " + s.id);
        System.out.println("Name: " + s.name);
        System.out.println("Age: " + s.age);
        System.out.println("Course: " + s.course);
        System.out.println("Phone: " + s.phone);
    }

    // Helper to safely read integer input
    static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
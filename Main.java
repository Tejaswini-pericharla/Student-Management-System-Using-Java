import java.util.*;
import java.util.regex.*;  // Add this import statement

public class Main {
    private static int MAX_NUMBER_OF_STUDENTS = 100;
    private static Student[] students = new Student[MAX_NUMBER_OF_STUDENTS];
    private static int studentsNumber = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean shouldRun = true;

        while (shouldRun) {
            System.out.println("Enter a command (add, search, sort, view, exit):");
            String command = input.nextLine();

            switch (command) {
                case "add":
                    addStudent(input);
                    break;
                case "search":
                    searchStudents(input);
                    break;
                case "sort":
                    sortStudents(input);
                    break;
                case "view":
                    viewStudents();
                    break;
                case "exit":
                    shouldRun = false;
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
        input.close();
    }

    private static void addStudent(Scanner input) {
        if (studentsNumber == MAX_NUMBER_OF_STUDENTS) {
            System.out.println("Maximum number of students reached");
            return;
        }

        System.out.println("Enter the student name:");
        String name = input.nextLine();

        System.out.println("Enter the student ID:");
        int ID = input.nextInt();
        input.nextLine();

        System.out.println("Enter the student email:");
        String email = input.nextLine();

        while (!isValidEmail(email)) {
            System.out.println("Wrong email, try again: ");
            email = input.nextLine();
        }

        System.out.println("Enter the student age:");
        int age = input.nextInt();
        input.nextLine();

        System.out.println("Enter the student GPA:");
        double GPA = input.nextDouble();
        input.nextLine();

        Student newStudent = new Student(name, email, ID, age, GPA);
        students[studentsNumber] = newStudent;
        studentsNumber++;

        System.out.println("Student added successfully");
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    private static void searchStudents(Scanner input) {
        System.out.println("Enter the student name: ");
        String name = input.nextLine();

        for (int i = 0; i < studentsNumber; i++) {
            if (students[i].getName().equals(name)) {
                System.out.println(students[i]);
            }
        }
    }

    private static void sortStudents(Scanner input) {
        System.out.println("Enter a field to sort by (name, ID, email, or GPA):");
        String field = input.nextLine();

        Arrays.sort(students, 0, studentsNumber, new StudentComparator(field));

        for (int i = 0; i < studentsNumber; i++) {
            System.out.println(students[i]);
        }
    }

    private static void viewStudents() {
        for (int i = 0; i < studentsNumber; i++) {
            System.out.println(students[i]);
        }
    }
}

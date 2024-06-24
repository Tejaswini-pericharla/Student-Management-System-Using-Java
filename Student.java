import java.util.*;

public class Student {
    private String name;
    private String email;
    private int ID;
    private int age;
    private double GPA;

    public Student(String name, String email, int ID, int age, double GPA) {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getID() {
        return this.ID;
    }

    public double getGPA() {
        return this.GPA;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + ID + "\nEmail: " + email + "\nGPA: " + GPA + "\n";
    }
}

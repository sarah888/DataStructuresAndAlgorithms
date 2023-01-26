package LA2Q2;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentGrade implements Comparable<StudentGrade> {
    //define fields
    private String firstName;
    private String lastName;
    private Integer grade;

    //define constructors
    public StudentGrade(String first, String last, Integer grade) {
        firstName = first;
        lastName = last;
        this.grade = grade;
    }

    public StudentGrade() {}

    //define setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    //define getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override //over
    public int compareTo(StudentGrade o) {
        int rv = 0;
        if (this.grade > o.grade) {
            rv = 1;
        } else if (this.grade < o.grade) {
            rv = -1;
        } else {
            rv = 0;
        }
        return rv;
    }

    @Override
    public String toString() {
        String fullName = firstName + " " + lastName;
        System.out.printf("%20s : %11d\n", fullName, grade);
        return " ";
    }
}
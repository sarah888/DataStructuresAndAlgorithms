package LE3Q2;

import java.util.*;

public class DriverForStudentClass {
    public static void myHeader(Student myInfo, int labE_number,int q_number) {//print header
        System.out.println("Lab Exercise 3-Q2\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with implementation!");
    }

    public static void myFooter(int labE_number,int q_number) {//prints footer
        System.out.println("Completion of Lab Exercise 3-Q2 is successful!");
        System.out.println("Signing off -Sarah");
    }

    public static void main(String[] args) {
        //print header
        System.out.println("=======================================================");
        myHeader( new Student(),3,2);
        System.out.println("=======================================================");

        ArrayList<Student> students = new ArrayList<>();
        //define variables
        Student s0 = new Student();
        Student s1 = new Student("Harry", "Potter", 75.5);
        Student s2 = new Student("Ronald", "Weasley", 86.0);
        Student s3 = new Student("Hermione","Granger", 91.7);
        Student s4 = new Student("Parvati", "Patil", 93.75);

        students.add(s0);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);


        //print current list
        System.out.println("The Score Card:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\t"+students.get(i));
        }

        //display descending order of scores
        Collections.sort(students,Collections.reverseOrder());
        System.out.println("\nThe sorted list in terms of score in descending order....");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\t"+students.get(i));
        }


        //display ascending order of last names
        Collections.sort(students, new HelperClassCompareLastNames());
        System.out.println("\nThe sorted list in terms of Last Names....");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\t"+students.get(i));
        }

        //display ascending order of first names
        Collections.sort(students, new HelperClassCompareFirstNames());
        System.out.println("\nThe sorted list in terms of First Names....");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\t"+students.get(i));
        }


        //print footer
        System.out.println("=======================================================");
        myFooter(3,2);
        System.out.println("=======================================================");
    }
}

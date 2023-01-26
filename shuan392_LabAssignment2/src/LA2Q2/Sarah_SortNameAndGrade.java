package LA2Q2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Sarah_SortNameAndGrade {
    public static void myHeader(int i) {//print header
        System.out.println("=======================================================\n" +
                "Lab Assignment 4\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with Algorithms!\n" +
                "=======================================================");
    }

    public static void myFooter(int i) {//prints footer
        System.out.println("=======================================================\n" +
                "Completion of Lab Assignment 2 is successful!\n" +
                "Signing off -Sarah\n" +
                "=======================================================");
    }

    public static void main(String[] args) {
        myHeader(2);
        //Three arrays with 8 first names, 8 last names and 8 randomly
        //generated grades between 60 and 85 inclusive have been created below
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        Vector<StudentGrade> sg = new Vector<StudentGrade>();
        for (int i = 0; i < 8; i++) { //append all student grade elements to sg
            StudentGrade student = new StudentGrade(fnArray[i], lnArray[i], grd[i]);
            sg.addElement(student);
        }

        //unsorted array
        System.out.println("The Unsorted Array ................");
        for (int i = 0; i < 8; i++) {
            sg.elementAt(i).toString();
        }

        //sort by grade
        System.out.println("\nSorted by Grades...........");
        Collections.sort(sg);
        for (int i = 0; i < 8; i++) {
            sg.elementAt(i).toString();
        }

        StudentGrade[] sgArray = new StudentGrade[fnArray.length];
        sg.copyInto(sgArray); //copy sg into sgArray

        // sort by first name
        System.out.println("\nSorted by First Names .............");
        insertionSort(sgArray, 1);

        //sort by last name
        System.out.println("\nSorted by Last Names .............");
        insertionSort(sgArray, 2);

        myFooter(2);

    }

    public static long insertionSort(StudentGrade[] a, int choice) {
        int l = a.length;
        if (choice == 1) {
            for (int i = 1; i < a.length; i++) {
                StudentGrade key = a[i];
                int j = i - 1;
                while (j >= 0 && a[j].getFirstName().compareTo(key.getFirstName()) > 0) {
                    //previous first name is greater than current first name
                    a[j + 1] = a[j]; //a[i] = a[j]
                    j = j - 1;
                }
                a[j + 1] = key;
            }

        } else {
            for (int i = 1; i < a.length; i++) {
                StudentGrade key = a[i];
                int j = i - 1;
                while (j >= 0 && a[j].getLastName().compareTo(key.getLastName()) > 0) {
                    //previous first name is greater than current first name
                    a[j + 1] = a[j]; //a[i] = a[j]
                    j = j - 1;
                }
                a[j + 1] = key;
            }
        }
        printArray(a);
        return 0;
    }

    public static <T> void printArray(StudentGrade[] array) {
        for (int i = 0; i < array.length; i++) { //format elements in the array
            System.out.print(array[i]+"\b");
        }
    }
}



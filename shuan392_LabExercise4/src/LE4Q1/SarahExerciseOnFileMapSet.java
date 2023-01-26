package LE4Q1;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class SarahExerciseOnFileMapSet {
    public static void myHeader(int labE_number, int q_number) {//print header
        System.out.println("Lab Exercise 4-Q1\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with TreeMap!");
    }

    public static void myFooter(int labE_number, int q_number) {//prints footer
        System.out.println("Completion of Lab Exercise 4-Q1 is successful!");
        System.out.println("Signing off -Sarah");
    }

    public static void main(String[] args) throws IOException {
        //print header
        System.out.println("=======================================================");
        myHeader(4,1);
        System.out.println("=======================================================");

        TreeMap<String, Integer> studentsLN = new TreeMap<>();//last name and integer value
        TreeMap<String, Integer> studentsFN = new TreeMap<>();//first name and integer value

        //open file
        File myFile = new File("C:\\Users\\huang\\SE2205\\shuan392_LabExercise4\\src\\LE4Q1\\SE2205Students.txt");
        Scanner inputFile = new Scanner(myFile);

        //check if the output file exists
        if (!myFile.exists()) {
            System.out.println("File not found");
            System.exit(0);
        }

        //read last names from file, add to treeMap
        while (inputFile.hasNext()) {
            String[] name = inputFile.nextLine().split(" ");
            String lastName = name[0];
            String firstName = name[name.length-1];

            //check last name
            if (studentsLN.get(lastName) == null) {
                studentsLN.put(lastName, 1);
            } else {
                int value = studentsLN.get(lastName);
                value++;
                studentsLN.put(lastName, value);
            }
            //check first name
            if (studentsFN.get(firstName) == null) {
                studentsFN.put(firstName, 1);
            } else {
                int value = studentsFN.get(firstName);
                value++;
                studentsFN.put(firstName, value);
            }
        }

        //close the file
        inputFile.close();

        //create a set with all entries
        Set<Map.Entry<String, Integer>> entrySetLN = studentsLN.entrySet();
        Set<Map.Entry<String, Integer>> entrySetFN = studentsFN.entrySet();

        //print lastName header
        System.out.println("List of the Number of students with the same Last Names:\n" +
                " Last-name \t\t\tnumbers\n" +
                "----------------------------------------");
        //get last name key value from each entry
        for (Map.Entry<String, Integer> entry : entrySetLN) {
            if (entry.getValue() > 1) {
                System.out.printf("%11s %11d\n", entry.getKey(), entry.getValue());
            }
        }

        //print first name header
        System.out.println("List of the Number of students with the same First Names:\n" +
                " First-name \t\t\tnumbers\n" +
                "----------------------------------------");
        //get first name key value from each entry
        for (Map.Entry<String, Integer> entry : entrySetFN) {
            if (entry.getValue() > 1) {
                System.out.printf("%11s %11d\n", entry.getKey(), entry.getValue());
            }
        }

        //print footer
        System.out.println("=======================================================");
        myFooter(4,1);
        System.out.println("=======================================================");
    }
}

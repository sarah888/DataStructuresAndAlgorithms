package Q_LE2;

import java.util.*;

public class GenericsAndArrays_Sarah {
    public static void header(int i){ //prints header
        System.out.println("Lab Exercise 2-Q1\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with arrays and exceptions!");
    }

    public static void footer(int i){ //prints footer
        System.out.println("Completion of Lab Exercise 2-Q1 is successful!");
        System.out.println("Signing off -Sarah");
    }

    public static void main(String[] args) throws Exception {
        //print header
        System.out.println("=======================================================");
        header(2);
        System.out.println("=======================================================");

        //student name and year array list
        ArrayList<String> studentName = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron" ,"Hermione", "Luna", "Vincent"));
        ArrayList<Integer> studentYear = new ArrayList(Arrays.asList(2,3,4,3,2,2));

        //intro header
        Scanner scanner = new Scanner(System.in); //call scanner
        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.");

        //loop the program until the user requests to break
        while (true) {
            //get input for academic year
            System.out.print("Enter Academic Year (2, 3 or 4):");
            int yearInput = 0;

            while(true) {
                try {
                    yearInput = scanner.nextInt(); //get user input
                    if(yearInput < 2 || yearInput > 4)
                        throw new ArithmeticException();
                    break;

                } catch (Exception ex) { //catch any non-integer exceptions
                    System.out.print("Incorrect Input! Enter Academic Year (2,3, or 4): ");
                    scanner.nextLine();
                }
                if (yearInput >= 2 && yearInput <= 4)
                    break;
            }

            //create and fill in array with student year and name
            Pair<Integer,String>[] profile = new Pair[studentName.size()];
            for (int i=0;profile.length>i; i++){
                profile[i] = new Pair<Integer,String> (studentYear.get(i),studentName.get(i));
                profile[i].setValue(studentName.get(i)); //set profile String as studentName equivalent
                profile[i].setKey(studentYear.get(i)); //set key String as studentYear equivalent
            }

            //fetch the names of students in inputted year
            ArrayList<String> nameList = new ArrayList();
            for (int i = 0;profile.length > i; i++) {
                if (profile[i].getKey().equals(yearInput)) { //check if years of students match year inputted
                    nameList.add(profile[i].getValue());//append students of inputted year into list
                }
            }

            //print # of leaders in year inputted
            System.out.printf("Found %d leader(s) from year %d.", nameList.size(), yearInput);

            //print list of names
            System.out.println("\nHere is the list:");
            System.out.println(nameList);

            //check if input requests to restart
            try {
                System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate):");
                String nextStep = scanner.next();

                if (nextStep.equals("y")) {}
                else { //if input does not equal y, break
                    break;
                }
            } catch (Exception ex) {//if user inputs a non string value, break
                break;// nextStep != y, will break out of loop
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap();


        //print footer
        System.out.println("=======================================================");
        footer(2);
        System.out.println("=======================================================");
    }
}


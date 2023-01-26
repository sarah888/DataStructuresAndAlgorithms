package Q2L2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class WorkingWithArrays {
    public static void header(int i){ //prints header
        System.out.println("Lab Exercise 1-Q2\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with arrays and conditional statements!");
    }

    public static void footer(int i){ //prints footer
        System.out.println("Completion of Lab Exercise 2 is successful!");
        System.out.println("Signing off -Sarah");
    }
    public static double[] mms5MethodSarah(int[] values){
        //find maximum value in array
        int maxValue = values[0];
        for(int maxCounter=0; maxCounter < values.length; maxCounter++){
            if (values[maxCounter] > maxValue){
                maxValue = values[maxCounter];
             }
        }
        //find minimum value in array
        int minValue = values[0];
        for(int minCounter=0; minCounter < values.length; minCounter++){
            if (values[minCounter] < minValue){
                minValue = values[minCounter];
            }
        }
        //find average of all array elements
        double avgValue = 0;
        int divisible5 = 0;
        for(int avgCounter=0;avgCounter < values.length; avgCounter++){
            if (values[avgCounter]%5 == 0){
                avgValue += values[avgCounter];
                divisible5++;
                System.out.println(avgValue);
            }
        }
        avgValue = avgValue/divisible5;
        if (divisible5 == 0){ //
            double[] arr = {0,0,0,0};
            return arr;
        }
        else {
            System.out.printf("Sarah found %d numbers that are divisible-by-5.", divisible5);
            double[] arr = {maxValue, minValue, avgValue,251215072};
            return arr;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        //format student number
        NumberFormat formatSN = new DecimalFormat();
        formatSN = new DecimalFormat("000000000");

        NumberFormat formatAvg = new DecimalFormat();
        formatAvg = new DecimalFormat("#0.00");

        System.out.println("======================================================="); //print border
        header(2);
        System.out.println("======================================================="); //print border

        System.out.print("Enter array size: "); //reading # of elements in array
        int size = scanner.nextInt(); //take size input
        int values[] = new int[size]; //empty array

        //collect array input values
        for (int i=0;i < size; i++){
            System.out.printf("Enter value %d:", i+1);
            values[i] = scanner.nextInt();//add scanner value to the array
        }

        //print out method results
        System.out.println("\nHere is the result......");

        double[] product = (mms5MethodSarah(values));
        if (product[3] == 0){ // results if there are no divisible by 5 numbers
            System.out.println("In the array, there was no number divisible by 5");
        }
        else{ //results if there are divisible by 5 numbers
            System.out.println("\nThe max is "+product[0]+ ".");
            System.out.println("The min is " +product[1]+ ".");
            System.out.println("The average of the numbers divisible by 5 is "+formatAvg.format(product[2])+ ".");
            System.out.println("My student number is "+formatSN.format(product[3])+ ".");
        }

        //print footer
        System.out.println("======================================================="); //print border
        footer(2);
        System.out.println("======================================================="); //print border
    }
}


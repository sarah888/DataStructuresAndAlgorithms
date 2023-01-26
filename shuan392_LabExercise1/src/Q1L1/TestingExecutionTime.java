package Q1L1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

    public class TestingExecutionTime{
        public static void header (int i){ //prints header
            System.out.println("Lab Exercise 1-Q1\n" +
                    "Prepared By: Sarah Huang\n" +
                    "Student Number: 251215072\n" +
                    "Goal of this Exercise: Checking code execution time!");
        }

        public static void footer (int i){
            System.out.println("Completion of Lab Exercise 1 is successful!");
            System.out.println("Signing off -Sarah");
        }

        public static double factorialIterative (int num) {
            //will return the factorial value when called
            double result = 1, i=1;
            while(i<=num){
                result = result*i;
                i++;
            }
            return result;
        }

        //will return the factorial value when called
        public static double factorialRecursive (int num){
            if (num==0){ //base case
                return 1;
            }
            else{
                return num * factorialRecursive(num-1);
            }
        }

        //nanoTime method header
        public static long nanoTime(){
            return System.nanoTime();
        }

        public static void main(String[] args){
            System.out.println("======================================================="); //print border
            header(1);
            System.out.println("======================================================="); //print border

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a positive integer number:");
            int number = scanner.nextInt(); //read user input
            while (number <= 0){ //continue asking for a valid number input
                System.out.print("Enter a positive integer number:");
                number = scanner.nextInt(); //read user input
            }
            //run iterative solution in main
            double result = 1, i=1;
            while(i <= number){
                result = result*i;
                i++;
            }
            //format time values in scientific notation
            NumberFormat formatTime = new DecimalFormat();
            formatTime = new DecimalFormat("0.##E00");
            //format factorial values in scientific notation
            NumberFormat formatFactorial = new DecimalFormat();
            formatFactorial = new DecimalFormat("0.E0");

            //print iterative solution in main
            long startTime1 = System.nanoTime();
            System.out.printf("Factorial %d is "+ formatFactorial.format(result),number);
            long predictedTime1 = (System.nanoTime()-startTime1);
            double time1 = predictedTime1*10e-9;//convert to seconds
            System.out.printf("\nTime taken by iterative method call: %s sec",formatTime.format(time1));

            //run iterative method
            long startTime2 = System.nanoTime();
            System.out.printf("\nFactorial %d with iterative method is " +
                    formatFactorial.format(factorialIterative(number)), number);
            long predictedTime2 = (System.nanoTime()-startTime2);
            double time2 = predictedTime2*10e-9;//convert to seconds
            System.out.printf("\nTime taken by iterative method call: %s sec",formatTime.format(time2));

            //run recursive method
            long startTime3 = System.nanoTime();
            System.out.printf("\nFactorial %d with recursive call is " +
                    formatFactorial.format(factorialRecursive(number)),number);
            long predictedTime3 = (System.nanoTime()-startTime3);
            double time3 = predictedTime3*10e-9;//convert to seconds
            System.out.printf("\nTime taken by iterative method call: %s sec",formatTime.format(time3));

            //print footer
            System.out.println("\n======================================================="); //print border
            footer(1);
            System.out.println("======================================================="); //print border
        }
     }

package LA1Q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DemoSinglyLinkedList {
    //define function
    private static Scanner input;

    //define constructors
    public DemoSinglyLinkedList() {}

    public static void queueDemo(SinglyLinkedList names) {
        //enqueue Joelle and Lukas
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");
        System.out.println("\nLet's enqueue Joelle and Lukas in the queue in sequence ....");
        System.out.println("\nThe current Queue: "+names);

        names.enqueueAtTail("Joelle"); //will queue and reprint new sequence
        System.out.print("After Joelle is enqueued, the revised Queue: " + names);
        names.enqueueAtTail("Lukas"); //will queue and reprint new sequence
        System.out.println("After Lukas is enqueued, the revised Queue: "+names);

        //dequeue the first 3 elements in sequence
        System.out.println("Let's dequeue first three elements from the queue in sequence ....");
        System.out.println("\nThe current Queue: "+names);//print the current queue

        while(names.getSize() != 0){
            System.out.print(names.dequeueAtHead());
            System.out.printf(" has been dequeued! The revised queue: "+names);
        }
        System.out.println(names);
            /**
        names.dequeueAtHead(); // //will dequeue Isra and reprint new sequence
        System.out.print("Isra has been dequeued! The revised queue: "+names);
        names.dequeueAtHead(); // //will dequeue Will and reprint new sequence
        System.out.print("Will has been dequeued! The revised queue: "+names);
        names.dequeueAtHead(); // //will dequeue Griffin and reprint new sequence
        System.out.println("Griffin has been dequeued! The revised queue: "+names);*/
    }

    public static void myHeader(int i) {//print header
        System.out.println("Lab Assignment 1\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with Singly Linked Lists!");
    }

    public static void myFooter(int i) {//prints footer
        System.out.println("Completion of Lab Assignment 1 is successful!");
        System.out.println("Signing off -Sarah");
    }

    public static void main(String[] args) {
        //print header
        System.out.println("=======================================================");
        myHeader(1);
        System.out.println("=======================================================");

        //declare integer ArrayList
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(56);
        numbers.add(-22);
        numbers.add(34);
        numbers.add(57);
        numbers.add(98);

        //declare integer ArrayList
        ArrayList<String> names = new ArrayList<String>();
        names.add("Griffin");
        names.add("Will");
        names.add("Isra");
        names.add("Delaney");
        names.add("Madison");

        //print arrays
        System.out.printf("The given Integer array: "+ numbers.toString());
        System.out.printf("\nThe given String array: %s", names.toString());

        //declare integer linked list
        SinglyLinkedList<Integer> numberList = new SinglyLinkedList<Integer>();
        numberList.addFirst(56);
        numberList.addFirst(-22);
        numberList.addFirst(34);
        numberList.addLast(98);
        numberList.addLast(57);
        System.out.print("\nYour Integer List: "+numberList);//print linked list

        //declare string linked list
        SinglyLinkedList<String> nameList = new SinglyLinkedList<String>();
        nameList.addFirst("Griffin");
        nameList.addFirst("Will");
        nameList.addFirst("Isra");
        nameList.addLast("Madison");
        nameList.addLast("Delaney");
        System.out.println("Your String List: "+nameList);//print linked list

        //call stackDemo method
        System.out.println("Stack demo with the Integer linked list ...");
        stackDemo(numberList);

        //call queueDemo method
        System.out.println("Queue demo with the String linked list ...");
        queueDemo(nameList);

        //search stack
        System.out.print("Let's search the stack...\nThe current stack: " + numberList);
        Scanner scanner = new Scanner(System.in); // define scanner

        //loop the program until the user requests to break
        while (true) {
            //get input for academic year
            System.out.print("Enter value you are searching for: ");
            int search = 0;

            while(true) {
                try {
                    search = scanner.nextInt(); //get user input
                    break;

                } catch (Exception ex) { //catch any non-integer exceptions
                    scanner.nextLine();
                }
                if (search >= 0 || search < 0)
                    break;
            }

            if (numberList.searchStack(search)==0){
                System.out.print("The value is not found!");
            }else{
                System.out.printf("The value %d is found in location %d from the top of the stack",
                        search, numberList.searchStack(search));
            }

            //check if input requests to restart
            try {
                System.out.print("\nDo you wish to continue? (Press y to continue or any other key to terminate):");
                String nextStep = scanner.next();

                if (nextStep.equals("y")) {}
                else { //if input does not equal y, break
                    break;
                }
            } catch (Exception ex) {//if user inputs a non string value, break
                break;// nextStep != y, will break out of loop
            }
        }

        //print footer
        System.out.println("=======================================================");
        myFooter(2);
        System.out.println("=======================================================");
    }

    public static void stackDemo(SinglyLinkedList numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which end of the Linked List would you like to use as the stack top? \n" +
                "Enter 1 for head or 2 for tail: ");
        int input = 0;

        while (true) {//ensure that input is valid integer 1 or 2
            try {
                input = scanner.nextInt(); //get user input
                if (input < 1 || input > 2)
                    throw new ArithmeticException();
                break;

            } catch (Exception ex) { //catch any non-integer exceptions
                System.out.print( "Invalid entry! Enter 1 for head or 2 for tail: ");
                scanner.nextLine();
            }
            if (input >= 1 && input <= 2)
                break;
        }

        if (input == 1) {//from head
            System.out.println("\nStack Top: Head of the linked list");//tell user which choice they made

            //pop out all elements from head
            System.out.println("\nLet's pop all the elements from the stack in sequence:");
            System.out.println("The current stack: " + numbers.toString());
            for (int i = numbers.getSize(); i > 0; i--) {
                System.out.print(numbers.removeFirst() + " Has been popped! The revised stack:" +
                        numbers.toString());
            }
            //push 39 and -58 in the stack
            System.out.println("\n\nLet's push 39 and -58 in the stack ....");
            System.out.println("The current stack: "+numbers);

            numbers.pushAtHead(39);
            System.out.print("After 39 is pushed, the revised stack:" + numbers.toString());
            numbers.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack:" + numbers.toString());

        } else {//from tail
            System.out.println("\nStack Top: Tail of the linked list");//tell user which choice they made

            //pop out 3 elements from tail
            System.out.println("Let's pop the first three elements from the stack in sequence:");
            System.out.printf("The current stack: "+ numbers.toString()+("\n"));
            for (int i = (numbers.getSize() - 2); i > 0; i--) {//iterate only 3 times
                System.out.print(numbers.popFromTail() + " Has been popped! The revised stack:" +
                        numbers);
            }
            //push 39 and -58 in the stack
            System.out.println("\nLet's push 39 and -58 in the stack ....");
            System.out.println("The current stack: "+ numbers);

            numbers.addLast(39);
            System.out.print("After 39 is pushed, the revised stack:"+ numbers);
            numbers.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack:"+ numbers);
        }
    }
}

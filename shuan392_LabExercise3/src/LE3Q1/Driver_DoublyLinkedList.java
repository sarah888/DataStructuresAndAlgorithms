package LE3Q1;

public class Driver_DoublyLinkedList {
    public static void myHeader(int labE_number,int q_number) {//print header
        System.out.println("Lab Exercise 3-Q1\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with Doubly Linked Lists!");
    }

    public static void myFooter(int labE_number,int q_number) {//prints footer
        System.out.println("Completion of Lab Exercise 3-Q1 is successful!");
        System.out.println("Signing off -Sarah");
    }

    public static void main(String[] args) {
        //print header
        System.out.println("=======================================================");
        myHeader(3,1);
        System.out.println("=======================================================");

        DoublyLinkedList<MyStudent> sarahList = new DoublyLinkedList<>();
        //create variables
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        //add to linked list
        sarahList.addLast(s0);
        sarahList.addLast(s1);
        sarahList.addLast(s2);
        sarahList.addLast(s3);

        //print the current list
        System.out.println("Adding 4 students to the list.");
        System.out.println("The list content:\n"+sarahList);

        //find node info for s2 and s3
        DoublyLinkedList.Node<MyStudent> name1 = sarahList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> name2 = sarahList.findNode(s2);

        //add s4 btwn s2 and s3
        System.out.println("Adding Hermione to the list in between Luna and Vincent.....");
        sarahList.addBetween(s4,name1,name2);

        //print the current list
        System.out.println("The list content:\n"+sarahList.toString());

        //print footer
        System.out.println("=======================================================");
        myFooter(3,1);
        System.out.println("=======================================================");
    }
}

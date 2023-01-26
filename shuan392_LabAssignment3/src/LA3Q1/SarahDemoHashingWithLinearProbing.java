package LA3Q1;

import java.util.Scanner;

public class SarahDemoHashingWithLinearProbing {
    //define fields
    public static int items; //total num of items added to hash table
    public static Scanner input = new Scanner(System.in);
    public static double lf; //record load factor
    public static int tableCapacity; //capacity of the hashtable
    public static SarahValueEntry[] hashTable;
    public static SarahValueEntry[] workingHashTable;//stores copy of the hashtable

    public static void addValueLinearProbe(Integer key){
        //add key to hash table by linear probing
        for (int i=0; i < hashTable.length; i++){
            int index = (key+i)%hashTable.length;
            if(index<0){
                index += hashTable.length;
            }

            if (hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111){
                hashTable[index].setKey(key);//cannot use set key bc of static fields
                return;
            }
        }
    }

    //define methods
    public static void reHashingWithLinearProbe(){
        workingHashTable = new SarahValueEntry[hashTable.length];
        System.arraycopy(hashTable, 0, workingHashTable, 0, hashTable.length);//copy current hashtable
        tableCapacity = checkPrime(hashTable.length * 2);//increase table capacity
        System.out.println("The rehashed table capacity is: " + tableCapacity);
        hashTable = new SarahValueEntry[tableCapacity];//redefine hashTable with increased table capacity
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new SarahValueEntry();
        }
        for (int i = 0; i < workingHashTable.length; i++) {
            if (workingHashTable[i] != null && workingHashTable[i].getKey() != -111) {
                addValueLinearProbe(workingHashTable[i].getKey());
            }
        }
    }

    public static void removeValueLinearProbe(Integer key){
        //removes key from hashTable
        for (int i=0; i < hashTable.length; i++){
            int index = (key+i)%hashTable.length;
            if(index < 0){
                index += hashTable.length;
            }
            if (hashTable[index].getKey() == -1) {//if null, won't be in the list
                System.out.printf("%d is not found! ", key);
                return;}
            if(hashTable[index].getKey() == key){//if key is found
                System.out.printf("%d is Found and removed! ", key);
                hashTable[index] = new SarahValueEntry(-111);
                return;//break out
            }//if available or a different int, may be the next index
        }
    }

    public static void printHashTable(){
        System.out.print("[");
        for(int i=0; i<tableCapacity; i++){
            if(hashTable[i].getKey() == -1){//print null if -1
                System.out.print("null, ");
            }else if (hashTable[i].getKey() == -111){//print available if -111
                System.out.print("available, ");
            }else {
                System.out.print(hashTable[i].getKey() + ", ");
            }
        }
        System.out.println("\b\b]");
    }

    public static void myHeader(int assignment, int question) {//print header
        System.out.println("=======================================================\n" +
                "Lab Assignment 4\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with Hashing!\n" +
                "=======================================================");
    }

    //since in hashing, the prime number has to be greater than 2, we can discard 2; 0 and 1 are not prime numbers by definition
    public static int checkPrime(int n) {
        int m = n / 2;//we just need to check half of the n factors
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {//if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the forheader
                //System.out.printf("i = %d\n",i);
                n++;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }

    public static void myFooter(int assignment, int question) {//prints footer
        System.out.println("=======================================================\n" +
                "Completion of Lab Assignment 2 is successful!\n" +
                "Signing off -Sarah\n" +
                "=======================================================");
    }

    public static void main(String[] args) {
        myHeader(3,1);// call header

        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.print("How many data items: ");
        items = input.nextInt();
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();
        tableCapacity = checkPrime((int) (items/lf));

        hashTable = new SarahValueEntry[tableCapacity];
        //redefine hashTable
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i]=new SarahValueEntry();
        }
        System.out.println("The minimum required table capacity would be: "+tableCapacity);
        for(int i=1; i<=items; i++){
            System.out.printf("Enter item %d: ",i);
            int num = input.nextInt();
            addValueLinearProbe(num); //add items to the hashtable
        }
        //print current hashTable
        System.out.print("The Current Hash-Table: ");
        printHashTable();

        System.out.println("\nLet’s remove two values from the table and then add one……");

        //remove value twice
        System.out.print("\nEnter a value you want to remove: ");
        int num1 = input.nextInt();//get input
        removeValueLinearProbe(num1);//remove chosen value
        System.out.print("The Current Hash-Table:");
        printHashTable();//print updated table

        System.out.print("\nEnter a value you want to remove: ");
        int num2 = input.nextInt();//get input
        removeValueLinearProbe(num2);//remove chosen value
        System.out.printf("The Current Hash-Table:");
        printHashTable();//print updated table

        //add value once
        System.out.print("\nEnter a value to add to the table: ");
        int num3 = input.nextInt();//get input
        addValueLinearProbe(num3);//add chosen value
        System.out.print("The Current Hash-Table:");
        printHashTable();//print updated table

        //rehash the table
        System.out.println("\nRehashing the table...");
        //get new capacity input
        reHashingWithLinearProbe();
        System.out.print("The Current Hash-Table:");
        printHashTable();//print updated table

        myFooter(3,1);//call footer
    }
}

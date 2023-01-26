package LA3Q2;
import LA3Q1.*; //this will import classes from the Q1 package

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static LA3Q1.SarahDemoHashingWithLinearProbing.*; //this will import all the static fields and methods from the driver class of the Q1 package

public class SarahDemoHashingWithAllOpenAddressingTechniques {
    public static void addValueDoubleHashing(Integer key){
        //add key to hash table by double probing
        int p = thePrimeNumberForSecondHashFunction(hashTable.length);
        for (int i=0; i < hashTable.length; i++){
            int index = (((key%hashTable.length)+i*(p-(key%p)))%hashTable.length);
            if(index<0){
                index += hashTable.length;//otherwise will return -1 instead of real modulus
            }
            if (hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111){
                hashTable[index] = new SarahValueEntry(key);//cannot use set key bc of static fields
                return;
            }
        }
    }
    public static void addValueQuadraticProbe(Integer key){
        //add key to hash table by quadratic probing
        for (int i=0; i < hashTable.length; i++){
            int index = (key+i*i)%hashTable.length;//i^2
            if(index<0){
                index += hashTable.length;
            }
            if (hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111){
                hashTable[index] = new SarahValueEntry(key);//cannot use set key bc of static fields
                return;
            }
        }
        if (lf > 0.5){
            System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        }
    }

    public static void printArray(Integer[] arr){//prints the array
        System.out.println(new ArrayList<Integer>(Arrays.asList(arr)));
    }

    public static void emptyHashTable(){
        //empties hashTable
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new SarahValueEntry();
        }
    }
    public static int thePrimeNumberForSecondHashFunction(int n){
        //gets the second-largest prime number
        for (int i = 0; true; i++) {
            if (checkPrime(i + (n / 2)) == n) {
                return checkPrime(i - 1 + (n / 2));
            }
        }
    }

    public static void main(String[] args) {
        myHeader(3,2);
        System.out.print("Let's demonstrate our understanding on all the open addressing techniques..." +
                "\nHow many data items: ");
        items = input.nextInt();
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();
        //calculate table capacity
        tableCapacity = checkPrime((int)(items/lf));
        hashTable = new SarahValueEntry[tableCapacity];
        //redefine hashTable
        for (int i = 0; i < tableCapacity; i++) {
            hashTable[i]=new SarahValueEntry();
        }
        System.out.print("\nThe minimum required table capacity would be: "+ tableCapacity);

        Integer[] arr = {7, 14, -21, -28, 35};//dataset
        System.out.print("\nThe given data set is: ");
        printArray(arr);

        //add by linear probing
        System.out.print("Let's enter each data item from the above to the hash table:\n\n" +
                "Adding data - linear probing resolves collision\n" +
                "The Current Hash-Table: ");
        for (int i = 0; i < arr.length; i++) {
            addValueLinearProbe(arr[i]);
        }
        printHashTable();
        emptyHashTable();

        //adding with quadratic probe
        System.out.println("\nAdding data - quadratic probing resolves collision");
        for (int i = 0; i < arr.length; i++) {
            addValueQuadraticProbe(arr[i]);
        }
        System.out.print("The Current Hash-Table: ");
        printHashTable();
        emptyHashTable();


        //adding with double hashing probe
        System.out.println("\nAdding data - double-hashing probing resolves collision");
        System.out.println("The q value for double hashing is: "+ thePrimeNumberForSecondHashFunction(hashTable.length));
        for (int i = 0; i < arr.length; i++) {
            addValueDoubleHashing(arr[i]);
        }
        System.out.print("The Current Hash-Table: ");
        printHashTable();

        myFooter(3,2);
    }
}

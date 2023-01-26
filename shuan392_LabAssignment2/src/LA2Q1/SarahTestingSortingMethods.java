package LA2Q1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class SarahTestingSortingMethods {
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long start = System.nanoTime(); //record start time
        for (int i = 0; i < a.length - 1; i++) {
            T currentMin = a[i];
            int currentMinIndex = i;//assume first element is min
            for (int j = i + 1; j < a.length; j++) { //check to see if there is another smaller value in the list
                if ( a[j].compareTo(currentMin)<0) { //check if a[i+1]<a[i]
                    currentMin = a[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) { //swap index
                a[currentMinIndex] = a[i];
                a[i] = currentMin;
            }
        }
        return System.nanoTime() - start;//get final time

    }

    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long start = System.nanoTime();//record start time
        boolean pass = true;
        for (int i = 0; i < a.length && pass; i++) {
            pass = false;//break out of loop when list is sorted in ascending order
            for (int j = 0; j < a.length - i; i++) {
                if (a[i].compareTo(a[i+1]) >0) {//check if current element is larger than next element, must swap
                    //swap a[i] with a[i+1]
                    T num = a[j];
                    a[i] = a[i + 1];
                    a[i + 1] = num;

                    pass = true;
                }
            }
        }
        return System.nanoTime() - start;//get final time
    }

    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long start = System.nanoTime();//record start time
        for (int i = 1; i < a.length; i++) {
            T currentElement = a[i];
            int k;
            //find where the current element fits into current sorted list
            for (k = i - 1; k >= 0 && a[k].compareTo(currentElement) >0; k--) {
                a[k + 1] = a[k];
            }
            // Insert the current element into list[k + 1]
            a[k + 1] = currentElement;
            }
                return System.nanoTime() - start;//get final time
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long start = System.nanoTime();//record start time
        int n = S.length;
        if (n < 2){ //split list cannot be 1 or 0
            return 0;
        }
        // divide
        int mid = n/2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half
        // merge sorted halves back into original
        int i = 0, j = 0;
        while (i + j < S.length) {
            //compare ith and jth element of the 2 lists
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                S[i+j] = S1[i++]; // copy ith element of S1 and increment i
            else
            S[i+j] = S2[j++]; // copy jth element of S2 and increment j
        }
        return System.nanoTime() - start;//get end time
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        long start = System.nanoTime();
        //base case
        if(b<=a || a>=b){}
        else{
            T pivot = s[a];
            int i = a+1;
            T temp;
            //partition array
            for(int j = a+1; j<= b; j++){
                if(pivot.compareTo(s[j]) > 0){
                    temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                    i++;
                }
            }
            //put pivot in right position
            s[a] = s[i-1];
            s[i-1] = pivot;

            //call qsort on right and left sides of pivot
            quickSort(s, a, i-2);
            quickSort(s, i, b);
        }
        return System.nanoTime() - start;
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long start = System.nanoTime();
        //since the radix is 10, creating 10 buckets using Vector. Assumption: positive numbers only
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        return System.nanoTime()-start;
    }
    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    public static void myHeader(int i) {//print header
        System.out.println("=======================================================\n"+
                "Lab Assignment 4\n" +
                "Prepared By: Sarah Huang\n" +
                "Student Number: 251215072\n" +
                "Goal of this Exercise: Working with Algorithms!\n" +
                "=======================================================");
    }

    public static void myFooter(int i) {//prints footer
        System.out.println("=======================================================\n"+
                "Completion of Lab Assignment 2 is successful!\n"+
                "Signing off -Sarah\n" +
                "=======================================================");
    }
    public static void main(String[] args) {
        myHeader(2);
        //create integer array
//        Integer[] array = new Integer[5];
        Integer[] array = new Integer[50000];//changed from 5 to 50000
        //create backup integer array
//        Integer[] backup = new Integer[5];
        Integer[] backup = new Integer[array.length];//changed from 5 to 50000
        //format time values in scientific notation
        NumberFormat formatTime = new DecimalFormat();
        formatTime = new DecimalFormat("0.00");

        //populate first array
        for (int i = 0; i < array.length; i++){
            array[i]=((int) (Math.random()*(94-13))+13);
        }

        //copy contents of array into backup
        System.arraycopy(array, 0, backup, 0,array.length);
        //create array contents in a list
        List<Integer> list = Arrays.asList(array);

        //collections
        System.out.print("Testing execution time of different sorting methods for sorting 5 random numbers:\n");
//        System.out.println("The unsorted list: " + list);
        long start = System.nanoTime();
        Collections.sort(list);
        System.out.println("Collections' Sorting Time: "+formatTime.format((System.nanoTime()-start)*10e-6)+" milliseconds");
//        System.out.print("The sorted list using Collections' sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //selection sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Selection-Sorting Time: %.2f milliseconds\n",selectionSort(array)*10e-6);
//        System.out.println("The sorted list using selection-sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //bubble sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n",selectionSort(array)*10e-6);
//        System.out.println("The sorted list using bubble-sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //insertion sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n",insertionSort(array)*10e-6);
//        System.out.println("The sorted list using insertion-sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //merge sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n",mergeSort(array)*10e-6);
//        System.out.println("The sorted list using merge-sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //quick sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n",quickSort(array, 0, array.length-1)*10e-6);
//        System.out.println("The sorted list using quick-sort method: "+ list);
        System.arraycopy(backup, 0, array, 0,array.length);//reset the array

        //bucket sort
//        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds\n",bucketSort(array, 0, array.length-1, 2)*10e-6);
//        System.out.println("The bucket list using insertion-sort method: "+ list);

        myFooter(2);
    }
}

// you name here
import java.util.*;

public class cmsc401 {
    // Make sure your code does not allocate any additional Scanner objects,
    // that is, there is only one Scanner object per running the whole program.
    // Using more than one scanner may seem to work when typing in input from keyboard,
    // but it doesn't work when redirecting the file to be used as input 
    // (e.g. "type my_input.txt | java cmsc401" in Windows command prompt
    // or "cat my_input.txt | java cmsc401" in linux or macosx command prompt)
    private static final Scanner scanner = new Scanner(System.in);

    // Please use these methods to take inputs and write outputs.
    private static Integer readInt() {
        return scanner.nextInt();
    }

    private static String readString() {
        return scanner.next();
    }

    private static Integer[] readIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }

    private static void printInt(int a) {
        System.out.println(a);
    }

    private static void printString(String s) {
        System.out.println(s);
    }

    public static void merge_sort(Integer[] arr){
        int n = arr.length;
        if(n<2){
            return;
        }

        int mid = n/2; //1

        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[n - mid];

        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        for(int i = mid; i < n; i++){
            right[i-mid] = arr[i]; 
        }
        merge_sort(left);
        merge_sort(right);

        merge(arr, left, right); 
    }

    public static void merge(Integer[] arr, Integer[] L, Integer[] R){
        int left_size = L.length;
        int right_size = R.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left_size && j<right_size){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<left_size){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<right_size){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {

//        // reading an Integer
//        Integer a = readInt();
//        // writing int output
//        printInt(a);
//
//        // reading a String
//        String s = readString();
//        // writing string output
//        printString(s);
//
//        // reading an Integer Array (you should provide the size)
//        Integer[] listOfIntegers = readIntegerArray(5);

        // write your code here
        Integer x = readInt();
        Integer[] arr = readIntegerArray(x);
        merge_sort(arr);
        for(int r = 0; r < arr.length; r++){
            System.out.println(arr[r]);
        }
    }
}

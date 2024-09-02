import java.util.*;

public class merge_sort {

    private static final Scanner scanner = new Scanner(System.in);

    private static Integer readInt()
    {
        return scanner.nextInt();
    }

    private static String readString()
    {
        return scanner.next();
    }

    private static Integer[] readIntegerArray(int size)
    {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = readInt();
        }
        return array;
    }

    private static void printInt(int a)
    {
        System.out.println(a);
    }

    private static void printString(String s)
    {
        System.out.println(s);
    }

    public static void merge_sort(Integer[] arr)
    {
        int n = arr.length;
        if(n<2)
        {
            return;
        }

        int mid = n/2;

        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[n - mid];

        for(int i = 0; i < mid; i++)
        {
            left[i] = arr[i];
        }
        for(int i = mid; i < n; i++)
        {
            right[i-mid] = arr[i]; 
        }
        merge_sort(left);
        merge_sort(right);

        merge(arr, left, right); 
    }

    public static void merge(Integer[] arr, Integer[] L, Integer[] R)
    {
        int left_size = L.length;
        int right_size = R.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left_size && j<right_size)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<left_size)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<right_size)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        Integer x = readInt();
        
        Integer[] arr = readIntegerArray(x);
        
        merge_sort(arr);
        
        for(int r = 0; r < arr.length; r++)
        {
            System.out.println(arr[r]);
        }
    }
}

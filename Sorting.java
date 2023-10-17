
import java.util.*;
/**
 * Sorting creates four different types of sorting algorithms. 
 *
 * @author Joshua Zhang
 * @version 10/17/23
 */
public class Sorting
{      
    private static long comparisons; // Counts the amount of comparisons for merge sort
    private static long swaps; // Counts the amount of swaps for merge sort
    
    // Sorts a number array in ascending order using the bubble sort algorithm 
    public static void bubbleSort(int[] arr)
    {
        long swaps = 0;
        long comparisons = 0;
        boolean sorted = true;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
        System.out.print("," + comparisons + "," + swaps);
    }
    
    // Sorts a number array in ascending order using the insertion sort algorithm 
    public static void insertionSort(int[] arr)
    {
        long swaps = 0;
        long comparisons = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            } 
            arr[j + 1] = temp;
        }
        System.out.print("," + comparisons + "," + (swaps / 3));
    }
    
    // Sorts a number array in ascending order using the selection sort algorithm 
    public static void selectionSort(int[] arr)
    {
        long comparisons = 0;
        long swaps = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            int minLocation = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr [minLocation]) {
                    minLocation = j;
                    swaps++;
                }
            }  
            int temp = arr[minLocation];
            arr[minLocation] = arr[i];
            arr[i] = temp;
        }
        System.out.print("," + comparisons + "," + swaps);
    }
    
    // Initiate the merge sort algorithm  
    public static void mergeSort(int[] arr)
    {
        comparisons = 0; 
        swaps = 0;  
        mergeSort(0, arr.length-1, arr);
        System.out.print("," + comparisons + "," + swaps);
    }
    
    // Splits the number array in half continuously until in pairs of two and initiates merge method
    public static void mergeSort(int beg, int end, int[] arr)
    {
        // base case
        if (beg == end) {
            return;
        // recursive case
        } else {
            int mid = (beg + end)/2;
            mergeSort(beg, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(beg, mid, end, arr);
        }
    }
    
    // Sorts the numbers into ascending order and then merges them back into one single array
    public static void merge(int beg, int mid, int end, int[] arr)
    {
        int newCur = 0;
        int left = beg;
        int right = mid + 1;
        int[] tempArr = new int[end - beg + 1];
        
        // Go through both partitions simultaneously 
        while (left <= mid && right <= end) {
            comparisons++;
            if (arr[left] < arr[right]) {
                tempArr[newCur] = arr[left];
                newCur++;
                left++;
            } else {
                tempArr[newCur] = arr[right];
                newCur++;
                right++; 
            }
        } 
        
        // Go through whatever is left of the partition 
        while (left <= mid) {
            tempArr[newCur] = arr[left];
            newCur++;
            left++;
        }
        // Go through whatever is left of the partition 
        while (right <= end) {
            tempArr[newCur] = arr[right];
            newCur++;
            right++;
        }
       
        // Copies sorted array to the original array 
        for (int i = 0; i < tempArr.length; i++) {
        arr[beg + i] = tempArr[i];
        swaps += 3;
        }   
    }
    
    // Test case for Bubble Sort 
    public void testBubbleSort()
    {
        int[] arrTest1 = {6,1,3,5,4,10,9};
        int[] arrTest2 = {1,2,6,7,7,7,3,4,9};
        
        bubbleSort(arrTest1);
        bubbleSort(arrTest2);
        System.out.println(Arrays.toString(arrTest1));
        System.out.println(Arrays.toString(arrTest2));
        
    }
    // Test case for Selection Sort 
    public void testSelectionSort()
    {
        int[] arrTest1 = {6,1,3,5,4,10,9};
        
        selectionSort(arrTest1);
        System.out.println(Arrays.toString(arrTest1));
    }
    
    // Test case for Merge Sort
    public void testMergeSort()
    {
        int[] arrTest1 = {2,4,6,90,1,5,2};
        
        mergeSort(arrTest1);
        System.out.println(Arrays.toString((arrTest1)));
        
    }
    
    // Test case for Insertion Sort
    public void testInsertionSort()
    {
        int[] arrTest1 = {2,4,5,1,10,5,9};
        
        insertionSort(arrTest1);
        System.out.println(Arrays.toString((arrTest1)));
    }
}
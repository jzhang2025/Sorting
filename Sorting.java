
import java.util. *;
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Sorting
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Sorting
     */
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                }
            }
        }
     
    }
    
    public void selectionSort(int[] arr)
    {
         for (int i = 0; i < arr.length - 1; i++) {
             int minLocation = i;
            for (int j = i; j < arr.length - 1; j++){
                if (arr [minLocation] < arr[j]) {
                    minLocation = j;
                }
        }
        int temp = arr[i];
        arr[i] = arr[minLocation];
        arr[minLocation] = temp;
    }
}

    
    public void mergeSort(int[] arr)
    {
        mergeSort(0, arr.length-1, arr);
    }

    
    public void mergeSort(int beg, int end, int[] arr)
    {
        if (beg == end){
            return;
        }
        else {
            int mid = (beg + end / 2);
            
            mergeSort(beg, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(beg, mid, end, int[] arr);
        }
    }
    
    public void merge(int beg, int mid, int end, int[] arr)
    {
        
        for (int i = beg ; i < mid; i++)
        {
            for (int j = mid + 1; j < end; j++)
            {
                if (arr[i] < arr[j]){ 
                    arr[i] = temp;
            }
        }
        int temp = arr[i];

    }
    public void testBubbleSort ()
    {
        int[] arrTest1 = {6,1,3,5,4,10,9};
        int[] arrTest2 = {1,2,6,7,7,7,3,4,9};
        bubbleSort(arrTest1);
        bubbleSort(arrTest2);
        System.out.println(Arrays.toString(arrTest1));
        System.out.println(Arrays.toString(arrTest2));
        
    }
    
    public void testSelectionSort()
    {
        int[] arrTest1 = {6,1,3,5,4,10,9};
        int[] arrTest2 = {1,2,6,7,7,7,3,4,9};
        selectionSort(arrTest1);
        selectionSort(arrTest2);
        System.out.println(Arrays.toString(arrTest1));
        System.out.println(Arrays.toString(arrTest2));
    }
    
    public void testMergeSort()
    {
        int[] arrTest1 = {1,2,3,4,5,6,7,8};
        mergeSort(arrTest1);
        System.out.println(Arrays.toString(arrTest1));
    }
    
}

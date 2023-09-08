
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
    public void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = temp;
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
            int mid = (beg + end)/2;
            
            mergeSort(beg, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(beg, mid, end, arr);
        }
    }
    
    public void merge(int beg, int mid, int end, int[] arr)
    {
       int newCur = 0;
       int left = beg;
       int right = mid + 1;
       int[] tempArr = new int[end - beg + 1];


       
       while (left <= mid && right <= end){
           if (arr[left] < arr[right]){
               tempArr[newCur] = arr[left];
               newCur++;
               left++;

           }
           else{
               tempArr[newCur] = arr[right];
               newCur++;
               right++;
               
               
           }
       }
       
       while (left <= mid){
           tempArr[newCur] = arr[left];
           newCur++;
           left++;
       }
       
       while (right <= end){
           tempArr[newCur] = arr[right];
           newCur++;
           right++;
           
       }
       
       for (int i = 0; i < tempArr.length; i++) {
        arr[beg + i] = tempArr[i];
    }
       
   
    }
    public void testBubbleSort()
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
        selectionSort(arrTest1);
        System.out.println(Arrays.toString(arrTest1));
    }
    
    public void testMergeSort()
    {
        int[] arrTest1 = {2,4,6,90,1,5,2};
        mergeSort(arrTest1);
        System.out.println(Arrays.toString((arrTest1)));
        
    }
    
    public void testInsertionSort()
    {
        int[] arrTest1 = {2,4,5,1,10,5,9};
        insertionSort(arrTest1);
        System.out.println(Arrays.toString((arrTest1)));
    }
}
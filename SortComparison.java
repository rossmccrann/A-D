import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  	insertion sort
*       Numbers 10: 0.003422ms
 *       Numbers 100: 0.130006ms
 *       Numbers 1000: 3.072544ms
 *       Numbers 1000 Duplicates:  0.535421ms
 *       1000 Nearly ordered: 0.277689ms
 *       Numbers Reverse 1000: 0.483532ms
 *       Numbers Sorted 1000: 0.187027ms
 *
 *  quick sort
 *       Numbers 10: 0.009123ms
 *       Numbers 100: 0.030221ms
 *       Numbers 1000: 0.364645ms
 *       Numbers 1000 Duplicates: 0.11119ms
 *       1000 Numbers Nearly Ordered: 0.056735ms
 *       Numbers Reverse 1000: 0.025659ms
 *       Numbers Sorted 1000: 0.028226ms
 *
 * merge sort iterative
 *       Numbers 10: 0.042195ms
 *       Numbers 100: 0.036778ms
 *       Numbers 1000: 0.43478ms
 *       Numbers 1000 Duplicates: 0.099785ms
 *       1000 Numbers Nearly Ordered: 0.075837ms
 *       Numbers Reverse 1000: 0.074696ms
 *       Numbers Sorted 1000: 0.072416ms
 *
 *
 *  merge sort recursive
 *       Numbers 10: 0.005987ms
 *       Numbers 100: 0.046757ms
 *       Numbers 1000: 0.210975ms
 *       Numbers 1000 Duplicates: 0.076122ms
 *       1000 Numbers Nearly Ordered: 0.062152ms
 *       Numbers Reverse 1000: 0.038774ms
 *       Numbers Sorted 1000: 0.039629ms
 *
 *  selection sort
 *       Numbers 10: 0.003136ms
 *       Numbers 100: 0.078403ms
 *       Numbers 1000: 4.616656ms
 *       Numbers 1000 Duplicates: 0.401138ms
 *       1000 Numbers Nearly Ordered: 0.277689ms
 *       Numbers Reverse 1000: 0.33756ms
 *       Numbers Sorted 1000: 0.271417ms
 *
 *
 *      Qa:
 *      The sorting algorithims impacted on but the order of input are the Insertion Sort and the Selection Sort.
 *      This is due to the algorithm requiring more iterations to order the input. 
 *      Both have O(n^2) due to the nested for loops in the algorithm.
 *
 *      Qb:
 *      The insertion Sort, Quick Sort and Selection Sort have the largest difference.
 *
 *      Qc: Quick Sort and Merge sort are the most scalable with O(NLogN) Runtime .
 *      Insertion and Selection are the worst with a runtime of  O(N^2)
 *
 *      Qd: 
 *      The Iterative Merge Sort took a longer time with Larger input numbers.
 *
 *      Qe: The iterative merge sort and the recursive merge sorts are the fastest
 */


// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	double temp;
    	for(int i = 1; i< a.length; i++){
    		for(int j = i; j > 0; j--){
    			if(a[j] < a[j-1]){
    				temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}
    	}
    	return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort (double a[]){
    return quickSort(a, 0, a.length - 1);	
    }
    	
    static double[] quickSort (double a[], int left, int right){
    if (left >= right) {
    	return null;
    }
    double pivot = a[(left + right) / 2];
    int index = partition(a, left, right, pivot);
    quickSort(a, left, index - 1);
    quickSort(a, index, right);
    return a;
    }
    
    public static  int partition(double[]a, int left , int right, double pivot){
    	while(left <= right) {
    		while(a[left] < pivot ) { 
    			left++;
    		}
    		
    		while(a[right] > pivot) {
    		right--;
    		}
    		
    		if(left <= right) {
    			swap(a, left, right);
    			left++;
    			right--; 
    		}
    	}
    	return left;
    }//end quicksort

    private static double[] swap(double[] a, int left, int right) {
		// TODO Auto-generated method stub
		double temp;
		temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		return a;
	}
  //end quicksort
	/**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
        int length = a.length;
        double[] aux = new double[length];
        for (int i = 1; i < length; i = i + i) {
            for (int low = 0; low < length - i; low += i + i) {
                merge(a, aux, low, low+i-1, Math.min(low+i+i-1,length-1));
            }
        }
        return a;

    }//end mergeSortIterative



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
        int length = a.length;
    	double[] aux = new double[a.length];
        sort(a, aux, 0, length-1);
        return a;

    }

    private static void sort(double[] a, double[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        sort(a, aux, low, middle);
        sort(a, aux, middle+1, high);
        merge(a, aux, low, middle, high);
    }

    private static void merge(double[] a, double[] aux, int low, int middle, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

    
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            if      (i > middle){
            	a[k] = aux[j++];
            }
            else if (aux[j] < aux[i]){
            	a[k] = aux[j++];
            }
            else if (j > high){
            	a[k] = aux[i++];
            }
            else {
            	a[k] = aux[i++];
            }
        }
    }
    //end mergeSortRecursive

    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    
    
	/**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] selectionSort(double a[]) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            double temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;


    }//end selectionsort

    public static void main(String[] args) {
    }


 

       
     }//end class
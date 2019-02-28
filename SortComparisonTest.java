import static org.junit.Assert.assertEquals; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Array;
import java.util.Arrays;

//-------------------------------------------------------------------------

/**
 * Test class for SortComparison.java
 *
 * @author Ross McCrann
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {

    @Test
    public void testConstructor() {
        new SortComparison();
    }
    
    @Test
    public void testInsertionSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.insertionSort(a));
    }

    @Test
    public void testRecursiveMergeSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.mergeSortRecursive(a));
    }

 @Test
    public void testQuickSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(null, SortComparison.quickSort(a));
    }

    @Test
    public void testIterativeMergeSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.mergeSortIterative(a));
    }

    @Test
    public void testInsertionSort() {
    	double[] a = {9.0, 5.0, 3.0, 11.0, 29.0, 17.0};
        double[] aSort = {3.0, 5.0, 9.0, 11.0, 17.0, 29.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.insertionSort(a)));
    }


    @Test
    public void testQuickSort() {
        double[] a = {9.0, 5.0, 3.0, 11.0, 29.0, 17.0};
        double[] aSort = {3.0, 5.0, 9.0, 11.0, 17.0, 29.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.quickSort(a)));
    }



    @Test
    public void testIterativeMergeSort() {
    	double[] a = {9.0, 5.0, 3.0, 11.0, 29.0, 17.0};
        double[] aSort = {3.0, 5.0, 9.0, 11.0, 17.0, 29.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortIterative(a)));
	}


   @Test
    public void testRecursiveMergeSort() {
    	double[] a = {9.0, 5.0, 3.0, 11.0, 29.0, 17.0};
        double[] aSort = {3.0, 5.0, 9.0, 11.0, 17.0, 29.0};
        Assert.assertEquals(Arrays.toString(aSort), Arrays.toString(SortComparison.mergeSortRecursive(a)));
    }


    @Test
    public void testSelectionSortEmpty() {
        double[] a = new double[0];
        Assert.assertEquals(a, SortComparison.selectionSort(a));
    }

    @Test
    public void testSelectionSort() {
    	double[] a = {9.0, 5.0, 3.0, 11.0, 29.0, 17.0};
        double[] aSort = {3.0, 5.0, 9.0, 11.0, 17.0, 29.0};
        Assert.assertEquals(Arrays.toString(aSort), 		  Arrays.toString(SortComparison.selectionSort(a)));
    }

   



}

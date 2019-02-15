/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.adt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author crist
 */
public class ArraySort {
    public static int count = 0;
    
    static public void optimizedQuickSort(int[] a, int left, int right)
    {
        if(left < right)
        {
            if(right - left <= 27)
            {
                insertionSort(a,left,right);
            }
            else
            {
                int[] pi = randomDualPartition(a,left,right);
                optimizedQuickSort(a,left,pi[0]-1);
                optimizedQuickSort(a,pi[0]+1,pi[1]-1);
                optimizedQuickSort(a,pi[1]+1,right);
            }
        }
    }
    static public void quickSort(int[] a, int left, int right)
    {
        if(left < right)
        {
            if(right - left <= 27)
            {
                insertionSort(a,left,right);
            }
            else {
            int pi = randomPartition(a,left,right);
            quickSort(a,left,pi-1);
            quickSort(a,pi+1,right);
            }
        }
    }
    
    static private int randomPartition(int[] a, int left, int right)
    {
        int randomNum = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(a,randomNum,right);
        return partition(a,left,right);
    }
    static private int[] randomDualPartition(int[] a, int left, int right)
    {
        int randomNum = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(a,randomNum,right);
        int randomNum2 = ThreadLocalRandom.current().nextInt(left, right + 1);
        while(randomNum2 == randomNum)
            randomNum2 = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(a,randomNum2,left);
        return dualPivotPartition(a,left,right);
    }
    
    static private int partition(int[] a, int left, int right)
    {
        int pivot = a[right];
        int i = left-1;
        for(int j = left; j < right; j++)
        {
            count++;
            if(a[j] < pivot)
            {
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,right);
        return i+1;
    }
    static private int[] dualPivotPartition(int[] a, int left, int right)
    {
        int[] pivots = new int[2];
        if(a[left] > a[right])
            swap(a,left,right);
        int pivotR = a[right];
        int pivotL = a[left];
        int less = left + 1;
        int great = right - 1;
        for (int k = less; k <= great; k++) {
            if (a[k] < pivotL) {
                swap(a, k, less++);
            } else if (a[k] > pivotR) {
                while (k < great && a[great] > pivotR) {
                    great--;
                }
                swap(a, k, great--);
                if (a[k] < pivotL) {
                    swap(a, k, less++);
                }
            }
        }
        swap(a, less - 1, left);
        swap(a, great + 1, right);
        pivots[0] = less-1;
        pivots[1] = great+1;
        return pivots;
    }
    static public void parallelMergeSort(int[] a, int l, int r)
    {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new ParallelMergeSort(a, l, r));
    }
    
    static public void hyperQuickSort(int[] a, int l, int r)
    {
        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new ParallelQuickSort(a, l, r));
    }
    
    static public void mergeSort(int[] a, int l, int r)
    {
        if(l < r)
        {
            int m = (l+r)/2;
            mergeSort(a, l, m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    
    static private void merge(int[] a, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++)
            L[i] = a[l+i];
        for(int i = 0; i < n2; i++)
            R[i] = a[m+1+i];
        int i = 0, j = 0;
        int k = l;
        while(i < n1 && j < n2)
        {
            count++;
            if(L[i] <= R[j])
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }
        while(j < n2)
        {
            a[k] = R[j];
            k++;
            j++;
        }
    }
    static public void insertionSort(int[] arr, int left, int right) 
    { 
        for (int i=left+1; i<=right; i++) 
        { 
            int key = arr[i]; 
            int j = i-1; 
            while (j>=0 && arr[j] > key) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
    public static void weirdSort(int[] data, int currentSize)
    {
        for(int i = 1; i < currentSize; i++)
        {
            if(data[i] < data[i-1])
            {
                for(int j = i; j >= 1; j--)
                {
                    if(data[j] < data[j-1])
                    {
                        swap(data,j,j-1);
                    }
                    else
                        break;
                }
            }
        }
    }
    public static void bubbleSort(int[] data, int currentSize, boolean asc)
    {
        int ok, n = currentSize;
        if(asc)
        {
            do
            {
                ok = 0;
                for(int i = 0; i < n-1; i++)
                {
                    count++;
                    if(data[i] > data[i+1])
                    {
                        swap(data,i,i+1);
                        ok = 1;
                    }
                }
                n--;
            }while(ok==1);
        }
        else
        {
            do
            {
                ok = 0;
                for(int i = 0; i < n-1; i++)
                {
                    if(data[i] < data[i+1])
                    {
                        swap(data,i,i+1);
                        ok = 1;
                    }
                }
                n--;
            }while(ok==1);
        }
    }
    public static void cocktailShaker(int[] array, int currentSize) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= currentSize - 2; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array,i,i+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = currentSize - 2; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    swap(array,i,i+1);
                    swapped = true;
                }
            }
        } while (swapped == false);
    }
    public static void shuttlesort(int[] a, int n) 
    {
        int temp, j;
        for (int i = 0; i < n - 1; i++) 
        {
            if (a[i] > a[i + 1]) 
            {
                j = i - 1;
                temp = a[i + 1];	
                a[i + 1] = a[i];
                while (j >= 0 && a[j] > temp) 
                {
                    a[j + 1] = a[j];	
                    j = j - 1;
                }	
                a[j + 1] = temp;	
            }		
        }	
    }
    public static void selectionSort(int[] a, int n)
    {
        for(int i = 0; i < n-1; i++)
        {
            int mindex = i;
            for(int j = i+1; j < n; j++)
                if(a[j] < a[mindex])
                    mindex = j;
            swap(a,i,mindex);
        }
    }
    public static void bucketSort(int[] a, int max, int min, int n)
    {
        int M = max - min;
        int bucketsLength = n;
        List<List<Integer>> buckets = new ArrayList<>(bucketsLength);
        for(int i = 0; i < bucketsLength; i++) 
            buckets.add(new ArrayList<>());
        //placing each element in a bucket
        for (int i = 0; i < n; i++) 
        {
            //bi is bucket index
            int bi = a[i] / M;
            List<Integer> bucket = buckets.get(bi);
            bucket.add(a[i]);
        }
         // Sort buckets and concatinate results
        int j = 0;
        for (int bi = 0; bi < bucketsLength; bi++) 
        {
            List<Integer> bucket = buckets.get(bi);
            if (bucket != null) 
            {
                Collections.sort(bucket);
                for (int k = 0; k < bucket.size(); k++) 
                {
                    a[j++] = bucket.get(k);
                }
            }
        }
    }
    static private void swap(int[] a, int i, int j)
    {
        int x;
        x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.adt;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author v8002382
 */
public class ArrayADT
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        long sum1 = 0, sum2 = 0;
//        for (int o = 0; o < 100; o++) 
//        {
//            ADT array = new ADT(10);
//            ADT array2 = new ADT(10);
//            int n = ThreadLocalRandom.current().nextInt(50000000, 50000001);
//            for (int i = 0; i < n; i++) 
//            {
//                int randomNum = ThreadLocalRandom.current().nextInt(1, 100000);
//                array.add(randomNum);
//                array2.add(randomNum);
//            }
//            long tStart = System.currentTimeMillis();
//            array.javaSort();
//            long tEnd = System.currentTimeMillis();
//            long yDelta = tEnd - tStart;
//            sum1 += yDelta;
//            System.out.println(yDelta);
//            //System.out.println(array.printToString());
//            tStart = System.currentTimeMillis();
//            array2.optimizedQuickSort();
//            tEnd = System.currentTimeMillis();
//            long tDelta = tEnd - tStart;
//            System.out.println(tDelta);
//            sum2 += tDelta;
//            //System.out.println(array2.printToString());
//        }
//        System.out.println("Java sort: " + sum1 / 100);
//        System.out.println("HyperQuick: " + sum2 / 100);
        int[] a = {35,75,4,8,6};
        LinkedList list = new LinkedList(a, 5);
        list.print();
    }

}

/**
 * This implementation of a heap is based on the algorithms for Heapsort in
 * Introduction to Algorithms by Cormen, Leiserson, Rivest
 *
 * It was slightly modified so that it it could handle a 0 based array instead
 * of a 1 based array.
 */

package dheisler.util;

import java.util.ArrayList;

public class MyHeap
{
    private ArrayList<Integer> myArray;

    public MyHeap()
    {
        myArray = new ArrayList<Integer>();
    }


    protected int getParentIndex(int index)
    {
        return (index - 1)/2;
    }

    protected int getLeftChildIndex(int index)
    {
        return (2 * index) + 1;
    }

    protected int getRightChildIndex(int index)
    {
        return (2 * index) + 2;
    }
}

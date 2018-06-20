/*
 * These tests were not written by TDD since I am coding from an algorithm.
 * They were written immediately after each addition.
 */
package dheisler.util;

import dheisler.util.MyHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyHeapTest
{
    private static Comparator<Integer> maxComp;
    private static Comparator<Integer> minComp;
    private MyHeap<Integer> minHeap;
    private MyHeap<Integer> maxHeap;

    @BeforeAll
    public static void defineComparators()
    {
        maxComp = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        };

        minComp = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        };
    }

    @BeforeEach
    public void defineHeaps()
    {
        minHeap = new MyHeap<>(minComp);
        maxHeap = new MyHeap<>(maxComp);
    }

    @Test
    public void testGettingParentChildIndices()
    {
        MyHeap<Integer> myHeap = new MyHeap<>(maxComp);
        assertEquals(0, myHeap.getParentIndex(1));
        assertEquals(0, myHeap.getParentIndex(2));
        assertEquals(4, myHeap.getParentIndex(10));

        assertEquals(1, myHeap.getLeftChildIndex(0));
        assertEquals(2, myHeap.getRightChildIndex(0));
        assertEquals(7, myHeap.getLeftChildIndex(3));
    }

    @Test
    public void testAddingOneMaxElement()
    {
        maxHeap.insert(new Integer(1));
        assertEquals(Integer.valueOf(1), maxHeap.peek());
    }

    @Test
    public void testAddingOneMinElement()
    {
        minHeap.insert(new Integer(1));
        assertEquals(Integer.valueOf(1), minHeap.peek());
    }

    @Test
    public void testAddingTwoIncreasingElementsMax()
    {
        maxHeap.insert(new Integer(1));
        maxHeap.insert(new Integer(2));
        assertEquals(Integer.valueOf(2), maxHeap.peek());
    }

    @Test
    public void testAddingTwoIncreasingElementsMin()
    {
        minHeap.insert(new Integer(1));
        minHeap.insert(new Integer(2));
        assertEquals(Integer.valueOf(1), minHeap.peek());
    }

}
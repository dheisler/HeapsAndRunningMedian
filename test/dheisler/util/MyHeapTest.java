/**
 * Author: Debbie Heisler
 * Date: June 2018
 *
 * These tests were not written by TDD since I am coding from an algorithm.
 * They were written immediately after each addition.  Ok, that is not 100% true.
 */
package dheisler.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyHeapTest
{
    private static Comparator<Integer> maxComp = Comparator.naturalOrder();
    private static Comparator<Integer> minComp = Comparator.reverseOrder();
    private MyHeap<Integer> minHeap;
    private MyHeap<Integer> maxHeap;

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

    @Test
    public void testIndirectlyThelastItemIsPutFirst()
    {
        maxHeap.insert(new Integer(10));
        maxHeap.insert(new Integer(5));
        assertEquals(Integer.valueOf(10), maxHeap.extract());
        assertEquals(Integer.valueOf(5), maxHeap.peek());
    }

    @Test
    public void testCorrectNewMaxNodeWhenExtractOne()
    {
        maxHeap.insert(new Integer(10));
        maxHeap.insert(new Integer(5));
        maxHeap.insert(new Integer(1));
        maxHeap.extract();
        assertEquals(Integer.valueOf(5), maxHeap.peek());
    }

    @Test
    public void testCorrectNewMinWhenExtractOne()
    {
        minHeap.insert(new Integer(5));
        minHeap.insert(new Integer(10));
        minHeap.insert(new Integer(1));
        minHeap.insert(new Integer(2));
        minHeap.insert(new Integer(20));
        assertEquals(Integer.valueOf(1), maxHeap.extract());
        assertEquals(Integer.valueOf(2), maxHeap.peek());
    }
}
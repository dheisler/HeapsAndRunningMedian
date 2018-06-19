package dheisler.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest
{

    @Test
    public void testGettingParentChildIndices()
    {
        MyHeap myHeap = new MyHeap();
        assertEquals(0, myHeap.getParentIndex(1));
        assertEquals(0, myHeap.getParentIndex(2));
        assertEquals(4, myHeap.getParentIndex(10));

        assertEquals(1, myHeap.getLeftChildIndex(0));
        assertEquals(2, myHeap.getRightChildIndex(0));
        assertEquals(7, myHeap.getLeftChildIndex(3));
    }

}
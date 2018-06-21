/**
 * Author: Debbie Heisler
 * Date: June 2018
 *
 * This implementation of a heap is based on the algorithms for Heapsort in
 * Introduction to Algorithms by Cormen, Leiserson, Rivest
 *
 * It was slightly modified so that it it could handle a 0 based array instead
 * of a 1 based array.
 *
 */


package dheisler.util;

import java.util.ArrayList;
import java.util.Comparator;

public class MyHeap<T>
{
    private ArrayList<T> myArray;
    private Comparator<T> myComparator;

    public MyHeap(Comparator<T> comparator)
    {
        myArray = new ArrayList<T>();
        myComparator = comparator;
    }

    public int size()
    {
        return myArray.size();
    }

    public void insert(T element)
    {
        myArray.add(element);
        int index = size() - 1;

        while (hasParent(index) &&
                myComparator.compare(myArray.get(index), parent(index)) > 0)
        {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public T peek()
    {
        if (size() == 0)
            throw new IllegalStateException();

        return myArray.get(0);
    }

    public T extract()
    {
        if (size() == 0)
            throw new IllegalStateException();

        T element = myArray.get(0);
        putLastItemFirst();
        heapify(0);

        return element;
    }

    private void heapify(int index)
    {
        int indexOfLargestItem = index;

        if (getLeftChildIndex(index) < size() &&
                myComparator.compare(leftChild(index), myArray.get(index)) > 0)
        {
            indexOfLargestItem = getLeftChildIndex(index);
        }

        if (getRightChildIndex(index) < size() &&
                myComparator.compare(rightChild(index), myArray.get(indexOfLargestItem)) > 0)
        {
            indexOfLargestItem = getRightChildIndex(index);
        }

        if (indexOfLargestItem != index)
        {
            swap(index, indexOfLargestItem);
            heapify(indexOfLargestItem);
        }
    }

    /*
     * Normally, I would make these all private, but in order to test them,
     * I have to make them protected.
     */
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

    private T parent(int index)
    {
        return myArray.get(getParentIndex(index));
    }

    private T leftChild(int index)
    {
        return myArray.get(getLeftChildIndex(index));
    }

    private T rightChild(int index)
    {
        return myArray.get(getRightChildIndex(index));
    }

    private boolean hasParent(int index)
    {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index) < size();
    }

    private boolean hasRightChile(int index)
    {
        return getRightChildIndex(index) < size();
    }

    private void swap(int firstIndex, int secondIndex)
    {
        T temp = myArray.get(firstIndex);
        myArray.set(firstIndex, myArray.get(secondIndex));
        myArray.set(secondIndex, temp);
    }

    private void putLastItemFirst()
    {
        if (size() > 1)
        {
            T temp = myArray.remove(size() - 1);
            myArray.set(0, temp);
        }
        else
        {
            myArray.remove(0);
        }
    }
}

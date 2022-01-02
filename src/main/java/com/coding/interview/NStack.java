package com.coding.interview;

import java.util.Arrays;

/**
 * Implement N > 0 stacks using a single array to store all stack data (you may
 * use auxiliary arrays in your stack object, but all of the objects in all of the stacks must
 * be in the same array). No stack should be full unless the entire array is full.
 *
 * N = 3 ;
 * capacity = 10;
 * Stacks stacks = new Stacks(N, capacity);
 * stacks.put(0 , 10);
 * stacks.put(2 , 11);
 * stacks.pop(0 ) = 10;
 * stacks.pop(2 ) = 11;
 */
public class NStack {

    /*
    Simple approach will be
    divide a array by N to create N stack.
    But in this approach we will not be utilizing full array.
    For eg:
    N = 3, then we will have 3 stacks
    arr = [0, 0, 0, 0, 0, 0, 0, 0, 0]
    stack1 = 0 to 2
    stack2 = 3 to 5
    stack3 = 6 to 9

    in this approach we cannot insert more than 3 elements in each stack
    even if we have space in neighbour stack.
     */

    private final int[] top; // this will contain the top index of each stack
    private final int[] data; // actual array to hold the data
    private final int[] pointer; // this will contain the next/previous index of the stack

    private int nextFreeIndex; // to store the index next free slot

    /**
     * Constructor to Initialize
     * @param k number of stack
     * @param arraySize array size
     */
    public NStack(int k, int arraySize) {
        top = new int[k];
        data = new int[arraySize];
        pointer = new int[arraySize];

        // initially next free slot will be 0
        nextFreeIndex = 0;

        // initialize all stack as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // initialize next index value in the pointer
        for (int i = 0; i < arraySize-1; i++)
            pointer[i] = i+1;

        // last element will not have next index value, so it as end
        pointer[arraySize-1] = -1;
    }

    /**
     * Push value into the specified stack
     * @param value
     * @param stack
     */
    public void push(int value, int stack) {
        if (isFull()) throw new IllegalStateException();

        // extract the next free slot value into currentIndex
        int currentIndex = nextFreeIndex;

        // update the next free slot from the pointer
        nextFreeIndex = pointer[currentIndex];

        // update the top index of the stack
        top[stack] = currentIndex;

        // update pointer by previous top index from stack
        pointer[currentIndex] = top[stack]; // backtracking of the stack, storing previous top

        // insert the value into the array
        data[currentIndex] = value;
    }

    public int pop(int stack) {
        if(isEmpty(stack)) throw new IllegalStateException();

        // find the top index of the stack
        int previousIndex = top[stack];

        // change the next free index to current top index
        nextFreeIndex = previousIndex;

        // change the top index of the stack from pointer (backtracking)
        top[stack] = pointer[previousIndex];

        // change the pointer value by next free slot value
        pointer[previousIndex] = nextFreeIndex;

        return data[previousIndex];
    }

    private boolean isEmpty(int stack) {
        return top[stack] == -1;
    }

    private boolean isFull() {
        return nextFreeIndex == -1;
    }


}

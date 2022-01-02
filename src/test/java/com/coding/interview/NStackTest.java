package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NStackTest {

    @Test
    public void testNStack() {
        int numberOfStack = 3, arraySize = 10;

        NStack nStack = new NStack(numberOfStack, arraySize);

        // push into stack 0
        nStack.push(5, 0);
        nStack.push(2, 0);
        nStack.push(1, 0);

        // push into stack 1
        nStack.push(25, 1);
        nStack.push(12, 1);
        nStack.push(8, 1);

        // push into stack 2
        nStack.push(8, 2);
        nStack.push(7, 2);
        nStack.push(9, 2);

        // pop from stack 1
        Assertions.assertEquals(8, nStack.pop(1));
        Assertions.assertEquals(12, nStack.pop(1));

        // pop from stack 2
        Assertions.assertEquals(9, nStack.pop(2));

        // pop from stack 0
        Assertions.assertEquals(1, nStack.pop(0));
    }

    @Test
    public void testExceptionWhilePush() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            int numberOfStack = 3, arraySize = 3;
            NStack nStack = new NStack(numberOfStack, arraySize);
            for (int i = 0; i < 5; i++) {
                nStack.push(i, 1);
            }
        });
    }

    @Test
    public void testExceptionWhilePop() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            int numberOfStack = 3, arraySize = 3;
            NStack nStack = new NStack(numberOfStack, arraySize);
            for (int i = 0; i < 3; i++) {
                nStack.push(i, 1);
            }
            for (int i = 0; i < 5; i++) {
                nStack.pop(1);
            }
        });
    }
}

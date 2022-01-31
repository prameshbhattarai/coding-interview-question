package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersIITest {

    public static final AddTwoNumbersII  addTwoNumbersII = new AddTwoNumbersII();

    public static final AddTwoNumbersII.ListNode l1 =
    new AddTwoNumbersII.ListNode(7,
            new AddTwoNumbersII.ListNode(2,
                    new AddTwoNumbersII.ListNode(4,
                            new AddTwoNumbersII.ListNode(3)
                    )
            )
    );

    public static final AddTwoNumbersII.ListNode l2 =
    new AddTwoNumbersII.ListNode(5,
            new AddTwoNumbersII.ListNode(6,
                    new AddTwoNumbersII.ListNode(4)
            )
    );

    public static final AddTwoNumbersII.ListNode expectedResult =
    new AddTwoNumbersII.ListNode(7,
            new AddTwoNumbersII.ListNode(8,
                    new AddTwoNumbersII.ListNode(0,
                            new AddTwoNumbersII.ListNode(7)
                    )
            )
    );

    public static final AddTwoNumbersII.ListNode l3 =
            new AddTwoNumbersII.ListNode(5);

    public static final AddTwoNumbersII.ListNode l4 =
            new AddTwoNumbersII.ListNode(5);

    public static final AddTwoNumbersII.ListNode expectedResult2 =
            new AddTwoNumbersII.ListNode(1,
                    new AddTwoNumbersII.ListNode(0)
            );

    @Test
    public void addNodeTest1() {
        AddTwoNumbersII.ListNode actualResult = addTwoNumbersII.addTwoNumber(l1, l2);
        Assertions.assertEquals(expectedResult, actualResult);

        actualResult = addTwoNumbersII.addTwoNumber(l3, l4);
        Assertions.assertEquals(expectedResult2, actualResult);
    }

    @Test
    public void addNodeTest2() {
        AddTwoNumbersII.ListNode actualResult = addTwoNumbersII.addTwoNumberUsingStack(l1, l2);
        Assertions.assertEquals(expectedResult, actualResult);

        actualResult = addTwoNumbersII.addTwoNumberUsingStack(l3, l4);
        Assertions.assertEquals(expectedResult2, actualResult);
    }

}

package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinaryTest {

    @Test
    public void testAddBinaryTest() {
        AddBinary addBinary = new AddBinary();
        String a = "11", b = "1";
        Assertions.assertEquals(addBinary.add(a, b), "100");

        a = "1010"; b = "1011";
        Assertions.assertEquals(addBinary.add(a, b), "10101");
    }
}

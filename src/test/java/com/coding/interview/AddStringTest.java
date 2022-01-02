package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddStringTest {

    @Test
    public void testAddStringTest() {
        AddString addString = new AddString();
        String a = "11", b = "123";
        Assertions.assertEquals(addString.add(a, b), "134");

        a = "456"; b = "88";
        Assertions.assertEquals(addString.add(a, b), "544");

        a = "0"; b = "9";
        Assertions.assertEquals(addString.add(a, b), "9");

        a = "0"; b = "0";
        Assertions.assertEquals(addString.add(a, b), "0");
    }
}

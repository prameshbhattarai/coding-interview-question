package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBoldTagInStringTest {

    private static final String test1 = "abcxyz123";
    private static final String[] dict1 = new String[]{"abc","123"};
    private static final String expected1 = "<b>abc</b>xyz<b>123</b>";

    private static final String test2 = "aaabbcc";
    private static final String[] dict2 = new String[]{"aaa","aab","bc"};
    private static final String expected2 = "<b>aaabbc</b>c";

    private static final AddBoldTagInString addBoldTagInString = new AddBoldTagInString();

    @Test
    public void testAddBoldTagInStringTest() {
        String actual = addBoldTagInString.apply(dict1, test1);
        Assertions.assertEquals(expected1, actual);

        actual = addBoldTagInString.apply(dict2, test2);
        Assertions.assertEquals(expected2, actual);
    }
}

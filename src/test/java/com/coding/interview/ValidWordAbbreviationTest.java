package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidWordAbbreviationTest {

    public static final ValidWordAbbreviation abbrev = new ValidWordAbbreviation();
    
    @Test
    public void test() {
        Assertions.assertTrue(abbrev.isValid("internationalization", "i12iz4n"));
        Assertions.assertFalse(abbrev.isValid("apple", "a2e"));
    }
}
